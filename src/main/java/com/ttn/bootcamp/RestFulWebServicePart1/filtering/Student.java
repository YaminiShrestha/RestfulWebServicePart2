package com.ttn.bootcamp.RestFulWebServicePart1.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@JsonFilter("StudentFilter")
public class Student {
    private String name;
    private String email;
    //    for static filtering
//    @JsonIgnore
    private String password;
}
