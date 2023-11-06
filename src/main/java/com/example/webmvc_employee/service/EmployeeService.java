package com.example.webmvc_employee.service;

import com.example.webmvc_employee.dto.EmployeeUpdateDTO;
import com.example.webmvc_employee.entity.Employee;
import com.example.webmvc_employee.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Transactional(readOnly = true)
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
    @Transactional(readOnly = true)
    public Employee getEmployee(String empId) {
        return employeeRepository.findById(empId);
    }

    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public void updateEmployee(EmployeeUpdateDTO employeeUpdateDTO) {
        Employee employee = employeeRepository.findById(employeeUpdateDTO.getEmpId());
        employee.setEmpType(employeeUpdateDTO.getEmpType());
        employee.setSalary(employeeUpdateDTO.getSalary());
        employeeRepository.save(employee);
    }

    public void deleteEmployee(String empId) {
        Employee emp = employeeRepository.findById(empId);
        if(emp != null) {
            employeeRepository.delete(emp);
        }
    }
}
