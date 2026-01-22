package dev.huggo.camelexample.service;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExampleService {

    @Autowired
    private CamelContext camelContext;

    private final ProducerTemplate producerTemplate;

    public ExampleService(ProducerTemplate producerTemplate) {
        this.producerTemplate = producerTemplate;
    }

    public void doStuff() {
        producerTemplate.sendBody("camel-endpoint", "Hello World");
    }
}
