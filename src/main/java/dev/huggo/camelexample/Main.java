package dev.huggo.camelexample;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

public class Main {
    public static void main(String[] args) {
        try (CamelContext camelContext = new DefaultCamelContext()) {
            camelContext.addRoutes(new ExampleRoute());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
