package com.example.demo.controller;

import com.example.demo.elasticsearch.BankEsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/elasticsearch")
public class ElasticsearchController {

    @Autowired
    private BankEsRepository bankEsRepository;

    @RequestMapping("/emails")
    public List<String> emails() {
        return bankEsRepository.getEmailsByAge(32L);
    }
}
