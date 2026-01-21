package dev.huggo.camelexample.route;

import org.apache.camel.builder.RouteBuilder;

public class ErrorHandlerExampleRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("timer:ticker?period=1s")
                .errorHandler(
                        deadLetterChannel("file:src/main/resources/files/error?fileName=example-error.txt")
                            .maximumRedeliveries(3))
                .setBody(simple("Hello World"))
                .process(exchange -> {
                    throw new RuntimeException("Example exception");
                })
                .log("Ended route with body: ${body}");

    }
}
