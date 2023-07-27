package com.indexer.apiindexer.controllers;

import com.indexer.apiindexer.dtos.ProductRequestDTO;
import com.indexer.apiindexer.dtos.ProductResponseDTO;
import com.indexer.apiindexer.models.Product;
import com.indexer.apiindexer.repositories.ProductElasticRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@Component
@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping(value = "products")
public class ProductController {
    private final ProductElasticRepository productElasticRepository;

    private ProductResponseDTO convertProductModelToResponseDto(final Product product) {
        return new ProductResponseDTO(product.getUuid(), product.getTitle(), product.getDescription());
    }
    @GetMapping(value = "/{uuid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductResponseDTO> getByUUID(@PathVariable("uuid") String uuid) {
        final Optional<Product> data = this.productElasticRepository.get(uuid);
        if(data.isEmpty()) {
            log.info("Product uuid:{} not found", uuid);
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        final Product product = data.get();
        final ProductResponseDTO response = this.convertProductModelToResponseDto(product);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductResponseDTO> createProduct(
            @RequestBody ProductRequestDTO data
    ){
        final String uuid = UUID.randomUUID().toString();
        log.info("Creating product uuid:{} with data:{}", uuid, data.toString());
        final Product product = new Product(uuid, data.getTitle(), data.getDescription());
        final boolean success = this.productElasticRepository.create(uuid, product);
        if(success)
            return new ResponseEntity<>(this.convertProductModelToResponseDto(product), HttpStatus.CREATED);
        return new ResponseEntity(HttpStatus.BAD_GATEWAY);
    }
}
