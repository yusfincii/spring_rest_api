package com.yusuf.controller;

import com.sun.net.httpserver.Authenticator;
import com.yusuf.model.Employee;
import com.yusuf.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/list-all")
    public List<Employee> getAllEmployeeList(){
        return employeeService.getAllEmployeeList();
    }

    @GetMapping(path = "/list-by-id/{id}")
    public Employee getEmployeeById(@PathVariable(name = "id", required = true) String id) throws Exception {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping(path = "/list-with-params")
    public List<Employee> listEmployeeWithParams(@RequestParam(name = "firstName") String firstName,
                                                 @RequestParam(name = "lastName") String lastName){
        return employeeService.getEmployeeWithParams(firstName, lastName);
    }

    @PostMapping(path = "/save-employee")
    public Employee saveEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }

    @DeleteMapping("/delete-employee/{id}")
    public boolean deleteEmployee(@PathVariable(name = "id") String id) throws Exception {
        return employeeService.deleteEmployee(id);
    }

    @PutMapping("/update-employee")
    public Employee updateEmployee(@RequestBody Employee newEmployee) throws Exception {
        return employeeService.updateEmployee(newEmployee.getId(), newEmployee);
    }
}
