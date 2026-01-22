package dev.huggo.camelexample.route;

import org.apache.camel.builder.RouteBuilder;

public class ExampleDirectRoute extends RouteBuilder {

    public static final String ROUTE_ID = "exampleDirectRoute";

    @Override
    public void configure() throws Exception {
        from("direct:example-direct-route")
                .routeId(ROUTE_ID)
                .log("Received request ${body}");
    }
}
