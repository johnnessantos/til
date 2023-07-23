package com.indexer.apiindexer.repositories;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.indexer.apiindexer.models.Product;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
@Slf4j
public class ProductElasticRepository {
    private final InMemoryElastic inMemoryElastic;

    private final ObjectMapper mapper;

    public boolean createProduct(Product product) {
        final String uuid = product.getUuid();
        try {
            final String data = this.mapper.writeValueAsString(product);
            return this.inMemoryElastic.create(uuid, data);
        } catch (JsonProcessingException e) {
            log.error("Failed insert uuid:{} document:{}", uuid, product.toString());
        }
        return false;
    }

    public Optional<Product> getProduct(final String uuid) {
        final Optional<String> data = this.inMemoryElastic.get(uuid);
        if (data.isEmpty()) return Optional.empty();
        try {
            return Optional.ofNullable(this.mapper.readValue(data.get(), Product.class));
        } catch (JsonProcessingException e) {
            log.error("Failed parser uuid:{} document:{}", uuid, data.get());
        }
        return Optional.empty();
    }

}
