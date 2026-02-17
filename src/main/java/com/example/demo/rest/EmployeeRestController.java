package com.example.demo.rest;

import com.example.demo.dao.EmployeeDAO;
import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.json.JsonMapper;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;
    private JsonMapper jsonMapper;

    @Autowired
    //inject employee dao (constructor injection)
    public EmployeeRestController(EmployeeService theEmployeeService, JsonMapper theJsonMapper){
        employeeService = theEmployeeService;
        jsonMapper = theJsonMapper;
    }


    //expose /employees and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){

        Employee theEmployee = employeeService.findById(employeeId);

        if(theEmployee == null){
            throw new RuntimeException("Employee id not found -" + employeeId);
        }

        return theEmployee;
    }


    // add a mapping for POST /employees - add new employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){

        theEmployee.setId(0);

        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;

    }

    // add a mapping for PUT /employees - update existing employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){

        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;

    }

    // add mapping for PATCH
    @PatchMapping("/employees/{employeeId}")
    public Employee patchEmployee(@PathVariable int employeeId,
                    @RequestBody Map<String, Object> patchPayload){

        Employee tempEmployee = employeeService.findById(employeeId);

        if(tempEmployee == null){
            throw new RuntimeException("Employee id not found");
        }
        if(patchPayload.containsKey("id")){
            throw new RuntimeException("Employee id not allowed in request body");
        }

        Employee patchedEmployee = jsonMapper.updateValue(tempEmployee, patchPayload);

        Employee dbEmployee = employeeService.save(patchedEmployee);

        return dbEmployee;


    }

    // add mapping for DELETE
    @DeleteMapping("employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){

        Employee theEmployee = employeeService.findById(employeeId);

        if(theEmployee == null){
            throw new RuntimeException("Employee id not found" + employeeId);
        }

        employeeService.deleteById(employeeId);

        return "Deleted employee id - " + employeeId;

    }

}
