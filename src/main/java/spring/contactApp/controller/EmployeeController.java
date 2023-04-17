package spring.contactApp.controller;

import oracle.jdbc.proxy.annotation.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.contactApp.entity.Employee;
import spring.contactApp.payload.ApiResponse;
import spring.contactApp.payload.EmployeeDTO;
import spring.contactApp.service.EmployeeService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public HttpEntity<?> getEmployees(){
        List<Employee> employees = employeeService.getEmployeesService();
        return ResponseEntity.ok(employees);
    }

    @PostMapping("/add")
    public HttpEntity<?> addEmployee(@RequestBody EmployeeDTO employeeDTO){
        ApiResponse apiResponse = employeeService.addEmployeeService(employeeDTO);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @DeleteMapping("/delete/{id}")
    public HttpEntity<?> deleteEmployee(@PathVariable UUID id){
        ApiResponse apiResponse = employeeService.deleteEmployeeService(id);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
}
