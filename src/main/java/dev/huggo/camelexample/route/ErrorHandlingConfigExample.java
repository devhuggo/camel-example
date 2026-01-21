package dev.huggo.camelexample.route;

import org.apache.camel.builder.RouteConfigurationBuilder;

public class ErrorHandlingConfigExample extends RouteConfigurationBuilder {

    @Override
    public void configuration() throws Exception {
        routeConfiguration("example-error-handling")
                .onException(Exception.class)
                .log("Exception: ${exception}")
                .maximumRedeliveries(3)
                .redeliveryDelay(300);
    }

}
