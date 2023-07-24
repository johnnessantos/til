package com.indexer.apiindexer.repositories;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.ElasticsearchException;
import co.elastic.clients.elasticsearch.core.IndexRequest;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.indexer.apiindexer.models.Product;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import com.indexer.apiindexer.configs.ElasticSearchConfig;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

@Component
@AllArgsConstructor
@Slf4j
public class ProductElasticRepository {
    private final ElasticsearchClient esClient = new ElasticSearchConfig().getESClient();
    private final ObjectMapper mapper;

    public boolean createProduct(Product product) {
        final String uuid = product.getUuid();
        IndexRequest<Product> request = IndexRequest.of(i -> i
                .index("products")
                .id(product.getUuid())
                .document(product)
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

    public Optional<Product> getProduct(final String uuid) {
        ArrayList<Product> products = new ArrayList<>();
        try {
            SearchResponse<Product> response = this.esClient.search(s -> s
                            .index("products")
                            .query(q -> q
                                    .term(t -> t
                                            .field("uuid")
                                            .value(v -> v.stringValue(uuid))
                                    )),
                    Product.class
            );
            for (Hit<Product> hit: response.hits().hits()) {
                products.add(hit.source());
            }
        } catch (ElasticsearchException | IOException ex) {
            log.error("Failed get uuid:{} error:{}", uuid, ex.getMessage());
            return Optional.empty();
        }

        if(products.isEmpty()) return Optional.empty();
        return Optional.ofNullable(products.get(0));
    }
}