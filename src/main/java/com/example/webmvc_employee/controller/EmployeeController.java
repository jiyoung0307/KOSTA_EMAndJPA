package com.example.webmvc_employee.controller;

import com.example.webmvc_employee.dto.EmployeeCreateDTO;
import com.example.webmvc_employee.dto.EmployeeUpdateDTO;
import com.example.webmvc_employee.entity.Employee;
import com.example.webmvc_employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping()
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{empId}")
    public Employee getEmployee(@PathVariable String empId) {
        return employeeService.getEmployee(empId);
    }

    @PostMapping
    public String addEmployee(@RequestBody EmployeeCreateDTO employeeCreateDTO) {
        employeeService.addEmployee(employeeCreateDTO);
        //edeptId, employee, employeeFamily);
        return "등록완료";
    }

    @PutMapping("/{empId}")
    public String updateEmployee(@PathVariable String empId,
                                 @RequestBody EmployeeUpdateDTO employeeUpdateDTO) {
        employeeService.updateEmployee(employeeUpdateDTO);
        return "수정완료";
    }

    @DeleteMapping("/{empId}")
    public String deleteEmployee(@PathVariable String empId) {
        employeeService.deleteEmployee(empId);
        return "삭제완료";
    }
}
