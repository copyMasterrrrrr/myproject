package com.lin;


import com.lin.dao.EmployeeMapper;
import com.lin.pojo.Department;
import com.lin.pojo.Employee;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
@SpringBootTest
public class jdbcTest {
    @Autowired
    DataSource dataSource;
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    EmployeeMapper employeeMapper;
    @Test
    public void d1() throws SQLException {
        //int i = employeeMapper.deleteEmployee(1);
        //Employee employee = employeeMapper.getEmployeeById(1);

        //Collection<Employee> employees = employeeMapper.getEmployees();
        //System.out.println(employees);
        Employee employee=new Employee();
        employee.setLastName("sssss");
        employee.setDepartment(new Department(101,"教学部"));
        employee.setEmail("1231asdasd@qq.com");
        employee.setGender(1);
        employee.setBirth(new Date());
        employee.setDepartmentId(101);
        int add = employeeMapper.add(employee);
        System.out.println("====================================");
        System.out.println("===========>"+add);
        System.out.println("====================================");


    }

}
