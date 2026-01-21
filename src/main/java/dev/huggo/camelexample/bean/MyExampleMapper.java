package dev.huggo.camelexample.bean;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.camel.Exchange;

public class MyExampleMapper {

    public void transform(Exchange exchange) {
        ObjectNode body = exchange.getMessage().getBody(ObjectNode.class);
        body.put("newField", "newValueBean");
        exchange.getMessage().setBody(body);
    }
}
