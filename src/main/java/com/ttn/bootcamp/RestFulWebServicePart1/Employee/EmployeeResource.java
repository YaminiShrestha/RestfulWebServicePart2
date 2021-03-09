package com.ttn.bootcamp.RestFulWebServicePart1.Employee;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/employees")
public class EmployeeResource {

    @Autowired
    private EmployeeDaoService employeeDaoService;

    @RequestMapping(method = RequestMethod.GET)
    @ApiModelProperty("All Employees Details")
    public List<Employee> retrievedEmployees() {
        return employeeDaoService.findAll();
    }

//    @GetMapping("/employees/{id}")
//    @ApiModelProperty(notes = "Employee Detail")
//    public Employee retrieveEmployee(@PathVariable int id) {
//        Employee employee = employeeDaoService.findOne(id);
//        if (employee == null)
//            throw new EmployeeNotFoundException("id- " + id);
//        return employee;
//    }


    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    @ApiModelProperty(notes = "employee detail")
    public EntityModel<Employee> getEmp(@PathVariable int id) {
        Employee employee = employeeDaoService.findOne(id);
        if (employee == null) throw new EmployeeNotFoundException("id- " + id);

        EntityModel<Employee> resource = EntityModel.of(employee);
        WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrievedEmployees());
        resource.add(linkTo.withRel("all-employees"));
        return resource;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ApiModelProperty(notes = "Create Employee")
    public ResponseEntity<Object> createEmployee(@Valid @RequestBody Employee employee) {
        Employee savedEmployee = employeeDaoService.save(employee);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedEmployee.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ApiModelProperty(notes = "Update Employee details")
    public ResponseEntity<Object> updateEmployee(@Valid @RequestBody Employee employee) throws EmployeeNotFoundException {
        Employee employee1 = employeeDaoService.updateEmployeeDetails(employee);
        if (employee1 == null)
            throw new EmployeeNotFoundException("Incorrect id");
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(employee1.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    @ApiModelProperty(notes = "Delete employee")
    public void deleteEmployee(@PathVariable int id) {
        Employee employee = employeeDaoService.deleteById(id);
        if (employee == null)
            throw new EmployeeNotFoundException("id- " + id);

    }

}
