package com.indexer.apiindexer.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductResponseDTO {
    String uuid;
    String title;
    String description;
}
