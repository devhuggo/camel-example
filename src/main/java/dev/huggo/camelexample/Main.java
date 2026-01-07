package dev.huggo.camelexample;

import dev.huggo.camelexample.route.ExampleRoute;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

public class Main {
    public static void main(String[] args) {
        try (CamelContext camelContext = new DefaultCamelContext()) {
            camelContext.addRoutes(new ExampleRoute());
            camelContext.start();
            Thread.sleep(2000);
            camelContext.stop();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
