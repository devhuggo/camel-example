package dev.huggo.camelexample.configuration;

import jakarta.jms.ConnectionFactory;
import org.apache.camel.component.jms.JmsComponent;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
//public class CamelConfiguration {
//
//    @Bean
//    public JmsComponent artemis(@Qualifier("Artemis") ConnectionFactory connectionFactory) {
//        JmsComponent jmsComponent = new JmsComponent();
//        jmsComponent.setConnectionFactory(connectionFactory);
//        return jmsComponent;
//    }
//}
