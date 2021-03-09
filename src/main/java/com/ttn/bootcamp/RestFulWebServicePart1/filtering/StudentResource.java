package com.ttn.bootcamp.RestFulWebServicePart1.filtering;


import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class StudentResource {

    @RequestMapping(method = RequestMethod.GET, path = "/students-static-filtered")
    @ApiModelProperty(notes = "Student list details")
    public List<Student> getStaticFilteringStudentDetails() {
        return Arrays.asList(new Student("Alex", "alex@gmail.com", "12345"),
                new Student("Harry", "harry@gmail.com", "56789"),
                new Student("Ian", "ian@gmail.com", "Ian@35"),
                new Student("Max", "max@gmail.com", "Max@123"));

    }

    @RequestMapping(method = RequestMethod.GET, path = "/students-dynamic-filtered")
    @ApiModelProperty(notes = "Student List Details")
    public MappingJacksonValue getDynamicFilteringStudentDetails() {
        List<Student> studentList = Arrays.asList(new Student("Alex", "alex@gmail.com", "12345"),
                new Student("Harry", "harry@gmail.com", "56789"),
                new Student("Ian", "ian@gmail.com", "Ian@35"),
                new Student("Max", "max@gmail.com", "Max@123"));
        SimpleBeanPropertyFilter simpleBeanPropertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept("name", "email");
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("StudentFilter", simpleBeanPropertyFilter);
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(studentList);
        mappingJacksonValue.setFilters(filterProvider);
        return mappingJacksonValue;

    }

}
