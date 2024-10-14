package com.example.demo;

import com.example.demo.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.stereotype.Controller;

@Controller
public class WorkerController {
    @Autowired
    private EmployeeRepository employeeRepository;


}
