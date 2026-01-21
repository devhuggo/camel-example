package dev.huggo.camelexample.route;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.camel.builder.RouteBuilder;

public class TransformExampleRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:src/main/resources/files?fileName=transform-example.txt&noop=true")
                .log("Body: ${body}, Headers: ${headers}")
                .transform(body().regexReplaceAll("Hello", "Bye"))
                .transform(simple("<request>${body}</request>"))
                .to("file:src/main/resources/files/output?fileName=transform-example.txt");
    }
}
