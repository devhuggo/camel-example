package dev.huggo.camelexample.bean;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.springframework.stereotype.Component;

@Component
public class ExampleMessageTransformer {

    private final ExampleMassageBodyMapper bodyMapper;

    private final ExampleMessageHeaderMapper headerMapper;

    public ExampleMessageTransformer(ExampleMassageBodyMapper bodyMapper, ExampleMessageHeaderMapper headerMapper) {
        this.bodyMapper = bodyMapper;
        this.headerMapper = headerMapper;
    }

    public void transform(Exchange exchange) {
        Message message = exchange.getMessage();
        String header = "example-header";

        message.setBody(bodyMapper.map(message.getBody(String.class)));
        message.setHeader(header, headerMapper.map(message.getHeader(header, String.class)));
    }
}
