package com.ttn.bootcamp.RestFulWebServicePart1.Employee;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class EmployeeDaoService {
    private static List<Employee> employeeList = new ArrayList<>();
    private static int employeeCount = 4;

    static {
        employeeList.add(new Employee(1, "Alex", 25));
        employeeList.add(new Employee(2, "Ben", 29));
        employeeList.add(new Employee(3, "Carl", 25));
        employeeList.add(new Employee(4, "Damon", 45));

    }

    public List<Employee> findAll() {
        return employeeList;
    }

    public Employee save(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(++employeeCount);
        }
        employeeList.add(employee);
        return employee;
    }

    public Employee findOne(int id) {
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    public Employee deleteById(int id) {
        Iterator<Employee> iterator = employeeList.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee.getId() == id) {
                iterator.remove();
                return employee;
            }
        }
        return null;
    }

    public Employee updateEmployeeDetails(Employee employee) {
        for (Employee employee1 : employeeList) {
            if (employee1.getId() == employee.getId()) {
                employee1.setName(employee.getName());
                employee1.setAge(employee.getAge());
                return employee1;
            }
        }
        return null;
    }
}
