package com.ttn.bootcamp.RestFulWebServicePart1.hello;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@ApiModel(description = "Welcome to Hello World")
public class HelloWorld {

    private String message;


}
