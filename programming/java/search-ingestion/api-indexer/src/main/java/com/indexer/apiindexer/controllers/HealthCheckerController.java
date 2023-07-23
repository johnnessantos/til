package com.indexer.apiindexer.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckerController {
    @GetMapping("/")
    public ResponseEntity index() {
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/healthcheck")
    public ResponseEntity<String> health() {
        return new ResponseEntity("ok", HttpStatus.OK);
    }
}
