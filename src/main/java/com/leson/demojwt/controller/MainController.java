package com.leson.demojwt.controller;

import com.leson.demojwt.dao.EmployeeDAO;
import com.leson.demojwt.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class MainController {
    @Autowired
    EmployeeDAO employeeDAO;

    @RequestMapping("/")
    @ResponseBody
    public String welcome() {
        return "Welcome to Spring Boot JWT example";
    }

    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        return "{greeting: Hello}";
    }

    @GetMapping("/employees")
    @ResponseBody
    public List<Employee> getEmployees() {
        List<Employee> employees = employeeDAO.getAllEmployees();
        return employees;
    }

    @GetMapping("/employees/{empNo}")
    @ResponseBody
    public Employee getEmployee(@PathVariable String empNo) {
        return employeeDAO.getEmployee(empNo);
    }

    @PostMapping("/employees")
    @ResponseBody
    public Employee addEmployee(@RequestBody Employee employee) {
        log.info("Adding employee no {}", employee.getEmpNo());
        return employeeDAO.addEmployee(employee);
    }

    @PutMapping("/employees")
    @ResponseBody
    public Employee updateEmployee(Employee employee) {
        log.info("Adding employee no {}", employee.getEmpNo());
        return employeeDAO.updateEmployee(employee);
    }

    @DeleteMapping("/employees/{empNo}")
    @ResponseBody
    public void deleteEmployee(@PathVariable String empNo) {
        log.info("Deleting employee no {}", empNo);
        employeeDAO.deleteEmployee(empNo);
    }
}
