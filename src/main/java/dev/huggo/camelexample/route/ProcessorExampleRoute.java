package dev.huggo.camelexample.route;

import org.apache.camel.builder.RouteBuilder;

public class ProcessorExampleRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:src/main/resources/files?fileName=processor-example.txt&noop=true")
                .log("Body: ${body}, Headers: ${headers}")
                .process(exchange -> {
                    String body = exchange.getMessage().getBody(String.class);
                    String transformedBody = body.toUpperCase();
                    
                    exchange.getMessage().setBody(transformedBody);

                })
                .to("file:src/main/resources/files/output?fileName=processor-example.txt");
    }
}
