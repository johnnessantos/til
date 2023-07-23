package com.indexer.apiindexer.repositories;

import java.util.Optional;

public interface ElasticSearch {
    boolean create(final String uuid, final String document);

    Optional<String> get(final String uuid);
}
