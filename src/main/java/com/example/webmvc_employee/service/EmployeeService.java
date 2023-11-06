package com.example.webmvc_employee.service;

import com.example.webmvc_employee.dto.EmployeeCreateDTO;
import com.example.webmvc_employee.dto.EmployeeUpdateDTO;
import com.example.webmvc_employee.entity.Department;
import com.example.webmvc_employee.entity.Employee;
import com.example.webmvc_employee.entity.EmployeeFamily;
import com.example.webmvc_employee.repository.DepartmentRepository;
import com.example.webmvc_employee.repository.EmployeeRepository;
import com.example.webmvc_employee.repository.FamilyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeService {
    //    부품 사용
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;
    private final FamilyRepository familyRepository;

    @Transactional(readOnly = true)
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Employee getEmployee(String empId) {
        return employeeRepository.findById(empId);
    }

    public void addEmployee(EmployeeCreateDTO employeeCreateDTO){
        //int deptId, Employee employee, EmployeeFamily family) {
        Department department = departmentRepository.findById(employeeCreateDTO.getDeptId());
        Employee employee = Employee.createEmployee(department, employeeCreateDTO);
        employeeRepository.save(employee);
        EmployeeFamily family = employee.getEmployeeFamily();
        familyRepository.save(family);
    }

    public void updateEmployee(EmployeeUpdateDTO employeeUpdateDTO) {
        Employee employee = employeeRepository.findById(employeeUpdateDTO.getEmpId());
        employee.setEmpType(employeeUpdateDTO.getEmpType());
        employee.setSalary(employeeUpdateDTO.getSalary());
        employeeRepository.save(employee);
    }

    public void deleteEmployee(String empId) {
        Employee emp = employeeRepository.findById(empId);
        if (emp != null) {
            employeeRepository.delete(emp);
        }
    }
}
