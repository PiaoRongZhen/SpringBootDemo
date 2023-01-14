package com.example.demo.elasticsearch;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BankEsRepository {

    @Autowired
    private ElasticsearchClient elasticsearchClient;

    public List<String> getEmailsByAge(Long age) {
        try {
            SearchResponse<ObjectNode> searchResponse = elasticsearchClient.search(s -> s
                            .index("bank")
                            .query(q -> q
                                    .term(t -> t
                                            .field("age")
                                            .value(v -> v.longValue(32))
                                    )
                            ),
                    ObjectNode.class);

            List<String> emails = new ArrayList<>();
            for (Hit<ObjectNode> hit : searchResponse.hits().hits()) {
                emails.add(hit.source().get("email").textValue());
            }
            return emails;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
