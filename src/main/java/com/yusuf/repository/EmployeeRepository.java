package com.yusuf.repository;

import com.yusuf.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {

    @Autowired
    private List<Employee> employeeList;

    public List<Employee> getAllEmployeeList(){
        return employeeList;
    }

    public Employee getEmployeeById(String id){
        Employee employee = null;

        for(Employee currentEmployee: employeeList){
            if(id.equals(currentEmployee.getId())){
                employee =  currentEmployee;
                break;
            }
        }
        return employee;
    }

    public List<Employee> getEmployeeWithParams(String firstName, String lastName){
        List<Employee> employees = new ArrayList<>();

        for(Employee currentEmployee: employeeList){
            if(firstName.equals(currentEmployee.getFirstName()) && lastName.equals(currentEmployee.getLastName())){
                employees.add(currentEmployee);
            }
        }
        return employees;
    }

    public Employee saveEmployee(Employee employee){
        employeeList.add(employee);
        return employee;
    }
    
}
