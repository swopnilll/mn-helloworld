package com.example.hello;

import jakarta.inject.Singleton;

@Singleton
public class HelloWorldSecondService implements MyService {

    public String helloFromService(){
        return "Hello World!";
    }
}
