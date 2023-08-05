package com.indexer.apiindexer.repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.indexer.apiindexer.models.Product;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@AllArgsConstructor
@Component
@Slf4j
public class InMemoryElastic implements ElasticSearch<Product> {
    private static final Map<String, String> DATABASE =
            new ConcurrentHashMap<>();

    private final ObjectMapper mapper;

    @Override
    @SneakyThrows
    public boolean create(final String uuid, final Product document) {
        DATABASE.put(uuid, mapper.writeValueAsString(document));
        return true;
    }

    @Override
    @SneakyThrows
    public Optional<Product> get(final String uuid) {
        final String data = DATABASE.get(uuid);
        if(data.isEmpty()) return Optional.empty();
        final Product product = mapper.readValue(data, Product.class);
        return Optional.ofNullable(product);
    }

    @Override
    @SneakyThrows
    public ArrayList<Product> searchByTitle(final String title) {
        ArrayList<Product> productResponses = new ArrayList<>();
        if(DATABASE.size() == 0) return productResponses;
        System.out.println(DATABASE.keySet());
        return productResponses;
    }

}
