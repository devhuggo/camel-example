package dev.huggo.camelexample.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;


@Component
public class ExampleRoute extends RouteBuilder {

    public static final String ROUTE_ID = "exampleRoute";

    @Override
    public void configure() throws Exception {
        from("artemis:{{example.queue.input.name}}?connectionFactory:{{example.queue.connection.factory}}")
                .routeId(ROUTE_ID)
                .log("Received request ${body}")
                .bean("exampleMessageTransformer")
                .to("artemis:{{example.queue.output.name}}");

    }
}
