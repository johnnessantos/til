package com.indexer.apiindexer.configs;


import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import lombok.AllArgsConstructor;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ElasticSearchConfig {
    private final RestClient restClient;
    private final ElasticsearchTransport esTransport;
    private final ElasticsearchClient esClient;

    public ElasticSearchConfig() {
        this.restClient = RestClient.builder(HttpHost.create("http://localhost:9200")).build();
        this.esTransport = new RestClientTransport(this.restClient, new JacksonJsonpMapper());
        this.esClient = new ElasticsearchClient(this.esTransport);
    }

    public ElasticsearchClient getESClient(){
        return this.esClient;
    }
}