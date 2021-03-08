package com.ttn.bootcamp.RestFulWebServicePart1.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class EmployeeResource {
    @Autowired
    private EmployeeDaoService employeeDaoService;

    @GetMapping("/employees")
    public List<Employee> retrievedEmployees() {
        return employeeDaoService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee retrieveEmployee(@PathVariable int id) {
        Employee employee = employeeDaoService.findOne(id);
        if (employee == null)
            throw new EmployeeNotFoundExecption("id- " + id);
        return employee;
    }

    @PostMapping("/employees")
    public ResponseEntity<Object> createEmployee(@Valid @RequestBody Employee employee) {
        Employee savedEmployee = employeeDaoService.save(employee);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedEmployee.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/employees")
    public ResponseEntity<Object> updateEmployee(@Valid @RequestBody Employee employee) throws EmployeeNotFoundExecption {
        Employee employee1 = employeeDaoService.updateEmployeeDetails(employee);
        if (employee1 == null)
            throw new EmployeeNotFoundExecption("Incorrect id");
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(employee1.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable int id) {
        Employee employee = employeeDaoService.deleteById(id);
        if (employee == null)
            throw new EmployeeNotFoundExecption("id- " + id);

    }
}
