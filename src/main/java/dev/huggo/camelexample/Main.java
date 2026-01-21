package dev.huggo.camelexample;


import dev.huggo.camelexample.bean.MyExampleMapper;
import dev.huggo.camelexample.route.BeanExampleRoute;
import dev.huggo.camelexample.route.ProcessorExampleRoute;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;



public class Main {
    public static void main(String[] args) {
        try (CamelContext camelContext = new DefaultCamelContext()) {
            camelContext.addRoutes(new ProcessorExampleRoute());
            camelContext.addRoutes(new BeanExampleRoute());

            camelContext.getRegistry().bind("my-transformer", new MyExampleMapper());

            camelContext.start();
            Thread.sleep(2000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
