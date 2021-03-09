package com.ttn.bootcamp.RestFulWebServicePart1.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @Autowired
    private MessageSource messageSource;

    @RequestMapping(method = RequestMethod.GET, path = "/hello")
    public HelloWorld helloWorld() {
        return new HelloWorld("Welcome to Spring Boot");
    }

    @RequestMapping(method = RequestMethod.GET, path = "/hello-employee")
    public String helloEmployee(@RequestParam String userName) {
        return messageSource.getMessage("good.morning.messages", null, LocaleContextHolder.getLocale()) + " " + userName;
    }
}
