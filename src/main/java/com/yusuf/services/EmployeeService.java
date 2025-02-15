package com.yusuf.services;

import com.yusuf.model.Employee;
import com.yusuf.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployeeList(){
        return employeeRepository.getAllEmployeeList();
    }

    public Employee getEmployeeById(String id) throws Exception {
        return employeeRepository.getEmployeeById(id);
    }

    public List<Employee> getEmployeeWithParams(String firstName, String lastName){
        return employeeRepository.getEmployeeWithParams(firstName, lastName);
    }

    public Employee saveEmployee(Employee employee){
        return employeeRepository.saveEmployee(employee);
    }

    public boolean deleteEmployee(String id) throws Exception {
        return employeeRepository.deleteEmployee(id);
    }

    public Employee updateEmployee(String id, Employee newEmployee) throws Exception {
        return employeeRepository.updateEmployee(id, newEmployee);
    }
}
