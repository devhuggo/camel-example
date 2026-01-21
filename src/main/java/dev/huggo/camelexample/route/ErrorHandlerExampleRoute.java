package dev.huggo.camelexample.route;

import org.apache.camel.builder.RouteBuilder;

public class ErrorHandlerExampleRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("timer:ticker?period=1s")
                .setBody(simple("Hello World"))
                .doTry()
                .process(exchange -> {
                    throw new RuntimeException("Example exception");
                })
                .doCatch(Exception.class).onWhen(simple("${exception.message} contains 'Example'"))
                .log("Catch Exception: ${exception}")
                .doFinally()
                .log("Finally: ${exception}")
                .end()
                .log("Ended route with body: ${body}");

    }
}
