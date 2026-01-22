package dev.huggo.camelexample.bean;

import org.springframework.stereotype.Service;

@Service
public class ExampleMessageHeaderMapper {

    public String map(String input) {
        return input.toUpperCase();
    }
}
