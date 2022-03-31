package com.example;

import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class HelloWorldControllerTest {

    @Inject
    @Client("/")
    HttpClient client;

    @Test
    void helloWorldEndPointRespondsWithProperContent(){
        var response = client.toBlocking().retrieve("/hello");
        assertEquals("Hello World!", response);
    }

    @Test
    void helloWorldEndPointRespondsWithProperStatusCodeAndContent(){
        var response = client.toBlocking().exchange("/hello", String.class);

        assertEquals(HttpStatus.OK, response.getStatus());
        assertEquals("Hello World!", response.getBody().get());
    }

    @Test
    void helloFromConfig(){
        var response = client.toBlocking().exchange("hello/config", String.class);

        assertEquals("Hello from application.yml", response.getBody().get());
    }

}
