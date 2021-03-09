package com.ttn.bootcamp.RestFulWebServicePart1.versioning;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonDetails {
    private String firstName;
    private String lastName;
    private String email;

}
