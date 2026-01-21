package dev.huggo.camelexample;


import dev.huggo.camelexample.route.ErrorHandlerExampleRoute;
import dev.huggo.camelexample.route.OnExceptionExampleRoute;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;



public class Main {
    public static void main(String[] args) {
        try (CamelContext camelContext = new DefaultCamelContext()) {
//            camelContext.addRoutes(new ErrorHandlerExampleRoute());
            camelContext.addRoutes(new OnExceptionExampleRoute());

            camelContext.start();
            Thread.sleep(2000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
