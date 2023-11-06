package com.example.webmvc_employee.repository;

import com.example.webmvc_employee.entity.Employee;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
class EmployeeRepositroyTest {
    @Autowired
    EmployeeRepositroy employeeRepositroy;

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