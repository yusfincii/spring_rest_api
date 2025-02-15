package com.yusuf.config;

import com.yusuf.model.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    public List<Employee> getAllEmployeeList(){
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("1", "Yusuf", "INCI"));
        employeeList.add(new Employee("2", "Ahmet", "INCI"));
        employeeList.add(new Employee("3", "Ali", "INCI"));
        employeeList.add(new Employee("4", "Ayse", "INCI"));

        return employeeList;
    }
}
