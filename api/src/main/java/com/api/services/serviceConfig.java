package com.api.services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.api.services.implementations.EmployeeService;
import com.api.services.interfaces.IEmployeeService;

@Configuration
public class serviceConfig {

    //Aca se eligen implementaciones a usarse
    @Bean
    public IEmployeeService employeeService(){
        return new EmployeeService();
    }
}
