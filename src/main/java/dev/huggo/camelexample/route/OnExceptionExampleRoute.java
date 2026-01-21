package dev.huggo.camelexample.route;

import org.apache.camel.builder.RouteBuilder;

public class OnExceptionExampleRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("timer:ticker?period=1s")
                .onException(Exception.class)
                    .log("Exception: ${exception}")
                    .maximumRedeliveries(3)
                    .redeliveryDelay(300)
                    .handled(true)
                .end()
                .setBody(simple("Hello World"))
                .process(exchange -> {
                    throw new RuntimeException("Example exception");
                })
                .log("Ended route with body: ${body}");

    }
}
