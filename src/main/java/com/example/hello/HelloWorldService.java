package com.example.hello;

import io.micronaut.context.annotation.Primary;
import jakarta.inject.Singleton;

@Singleton
@Primary
public class HelloWorldService implements MyService {

    @Override
    public String helloFromService(){
        return "Hello World!";
    }
}
