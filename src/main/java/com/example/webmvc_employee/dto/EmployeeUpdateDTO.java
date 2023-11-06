package com.example.webmvc_employee.dto;

import com.example.webmvc_employee.entity.EmpType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeUpdateDTO {
    private String empId;
    private EmpType empType;
    private Long salary;
}