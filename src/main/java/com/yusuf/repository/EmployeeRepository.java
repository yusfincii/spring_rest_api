package com.yusuf.repository;

import com.yusuf.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.FlashMapManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class EmployeeRepository {

    @Autowired
    private List<Employee> employeeList;

    public List<Employee> getAllEmployeeList(){
        return employeeList;
    }

    public Employee getEmployeeById(String id) throws Exception {
        Employee employee = null;

        for (Employee currentEmployee : employeeList) {
            if (id.equals(currentEmployee.getId())) {
                employee = currentEmployee;
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

    public boolean deleteEmployee(String id) throws Exception {
        for (Employee employee : employeeList) {
            if (Objects.equals(employee.getId(), id)) {
                employeeList.remove(getEmployeeById(id));
                return true;
            }
        }
        return false;
    }

    public Employee updateEmployee(String id, Employee newEmployee) throws Exception {
        for (Employee employee : employeeList) {
            if(employee.getId().equals(id)){
                employeeList.set(employeeList.indexOf(employee), newEmployee);
                return newEmployee;
            }
        }
        throw new Exception("An error occurred when updating employee!");
    }

}
