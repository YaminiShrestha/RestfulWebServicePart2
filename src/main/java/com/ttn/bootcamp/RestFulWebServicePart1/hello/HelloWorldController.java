package com.ttn.bootcamp.RestFulWebServicePart1.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @RequestMapping(method = RequestMethod.GET, path = "/hello")
    public HelloWorld helloWorld() {
        return new HelloWorld("Welcome to Spring Boot");
    }
}
