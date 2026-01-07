package dev.huggo.camelexample;

import org.apache.camel.builder.RouteBuilder;

public class ExampleRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:src/main/resources/files")
                .to("file:src/main/resources/files/output");
    }
}
