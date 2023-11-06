package com.example.webmvc_employee.repository;

import com.example.webmvc_employee.entity.Employee;
import jakarta.persistence.EntityManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeRepositroyTest {
    private jakarta.persistence.EntityManager EntityManager;
    private final com.example.webmvc_employee.repositroy.EmployeeRepositroy employeeRepositroy
            = new com.example.webmvc_employee.repositroy.EmployeeRepositroy(EntityManager);

    @Test
    @Transactional
    void findAll() {
        //given employee
        Employee employee = new Employee();
        employee.setEmpId("202301");
        employee.setEmpName("홍길동");
        employeeRepositroy.save(employee);
        //when
        List<Employee> employees = employeeRepositroy.findAll();
        //then
        Assertions.assertThat(employees.size()).isEqualTo(1);
    }
}