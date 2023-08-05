package com.indexer.apiindexer.repositories;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.ElasticsearchException;
import co.elastic.clients.elasticsearch.core.GetResponse;
import co.elastic.clients.elasticsearch.core.IndexRequest;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.indexer.apiindexer.configs.ElasticSearchConfig;
import com.indexer.apiindexer.models.Product;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

@Component
@AllArgsConstructor
@Slf4j
public class ProductElasticRepository implements ElasticSearch<Product> {

    private final ElasticsearchClient esClient = new ElasticSearchConfig().getESClient();
    private final ObjectMapper mapper;
    private final String INDEX_NAME = "products";

    @Override
    public boolean create(final String uuid, final Product product) {
        IndexRequest<Product> request = IndexRequest.of(i -> i
                .index(this.INDEX_NAME).id(uuid).document(product)
        );

        try{
            IndexResponse response = this.esClient.index(request);
            log.info("Inserted product uuid:{} with version:{}", uuid, response.version());
            return true;
        } catch (IOException | ElasticsearchException ex){
            log.error("Failed insert uuid:{} document:{}", uuid, product.toString());
        }
        return false;
    }

    @Override
    public Optional<Product> get(final String uuid) {
        try {
            GetResponse<ObjectNode> response = this.esClient.get(g -> g
                            .index(this.INDEX_NAME)
                            .id(uuid),
                    ObjectNode.class
            );
            if(response.found()) {
                return Optional.ofNullable(
                        mapper.readValue(response.source().toString(), Product.class)
                );
            }
        } catch (ElasticsearchException | IOException ex) {
            log.error("Failed get uuid:{} error:{}", uuid, ex.getMessage());
        }
        return Optional.empty();
    }
    
    @Override
    public ArrayList<Product> searchByTitle(final String title) {
        ArrayList<Product> products = new ArrayList<>();
        try {
            SearchResponse<ObjectNode> response = this.esClient.search(s -> s
                            .index("products")
                            .query(q -> q.match(t -> t.field("title").query(title))),
                    ObjectNode.class
            );
            for (Hit<ObjectNode> hit: response.hits().hits()) {
                products.add(mapper.readValue(hit.source().toString(), Product.class));
            }
        } catch (ElasticsearchException | IOException ex) {
            log.error("Failed search title:{} error:{}", title, ex.getMessage());
        }
        return products;
    }
}