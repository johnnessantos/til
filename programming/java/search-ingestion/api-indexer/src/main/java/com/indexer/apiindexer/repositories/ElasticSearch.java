package com.indexer.apiindexer.repositories;

import java.util.ArrayList;
import java.util.Optional;

public interface ElasticSearch<T> {
    boolean create(final String uuid, final T document);

    Optional<T> get(final String uuid);

    ArrayList<T> searchByTitle(final String title);
}
