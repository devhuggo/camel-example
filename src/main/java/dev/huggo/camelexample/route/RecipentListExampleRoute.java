package dev.huggo.camelexample.route;

import org.apache.camel.builder.RouteBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecipentListExampleRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("jms:recipientList.queue")
                .process(exchange -> {
                    Object departments = exchange.getMessage().getHeader("departments");
                    List<String> whereToSend = new ArrayList<>();
                    if(departments != null){
                        Arrays.asList(departments.toString().split(","))
                                .forEach(department->whereToSend.add("jms:" + department + ".queue"));
                    }
                    exchange.getMessage().setHeader("whereToSend", whereToSend);
                })
                .recipientList(header("whereToSend"))
        ;
    }
}
