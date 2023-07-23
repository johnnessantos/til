package com.indexer.apiindexer.repositories;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@RequiredArgsConstructor
@Component
@Slf4j
public class InMemoryElastic implements ElasticSearch {
    private static final Map<String, String> DATABASE =
            new ConcurrentHashMap<>();
    @Override
    public boolean create(final String uuid, final String document) {
        DATABASE.put(uuid, document);
        return true;
    }

    @Override
    public Optional<String> get(final String uuid) {
        final String data = DATABASE.get(uuid);
        return Optional.ofNullable(data);
    }
}
