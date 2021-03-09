package com.ttn.bootcamp.RestFulWebServicePart1.Employee;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Employee {
    @ApiModelProperty("Id should be unique")
    private Integer id;

    @Pattern(regexp = "[a-zA-Z][a-zA-Z ]*")
    @Size(min = 2, message = "name should be atleast of 2 character")
    @ApiModelProperty("Name should be greater than 2 character")
    private String name;

    @Min(value = 20, message = "Age should not be less than 20")
    @Max(value = 50, message = "Age should not be more than 50")
    @ApiModelProperty(notes = "Should be between 20 t0 50")
    private Integer age;


}
