package com.example.demo.elasticsearch;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.TransportUtils;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.elasticsearch.client.RestClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.net.ssl.SSLContext;

@Configuration
public class ElasticsearchConfig {
    @Bean
    public ElasticsearchClient elasticsearchClient() {

        String fingerprint = "BA:C3:FE:7F:3A:3A:68:BE:A1:D3:D8:CF:32:15:50:4A:C1:98:DA:62:C7:AC:CC:24:6E:99:47:64:93:D5:C9:B4";
        SSLContext sslContext = TransportUtils.sslContextFromCaFingerprint(fingerprint);

        BasicCredentialsProvider basicCredentialsProvider = new BasicCredentialsProvider();
        basicCredentialsProvider.setCredentials(
                AuthScope.ANY, new UsernamePasswordCredentials("elastic", "gmoNSWXk=lrie4crSMkp")
        );

        // Create the low-level client
        RestClient restClient = RestClient
                .builder(new HttpHost("localhost", 9200, "https"))
                .setHttpClientConfigCallback(hc -> hc
                        .setSSLContext(sslContext)
                        .setDefaultCredentialsProvider(basicCredentialsProvider))
                .build();

        // Create the transport with a Jackson mapper
        ElasticsearchTransport transport = new RestClientTransport(restClient, new JacksonJsonpMapper());

        // And create the API client
        ElasticsearchClient client = new ElasticsearchClient(transport);
        return client;
    }

}
