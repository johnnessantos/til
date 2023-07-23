package com.indexer.apiindexer.models;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Product {
    String uuid;
    String title;
    String description;
}
