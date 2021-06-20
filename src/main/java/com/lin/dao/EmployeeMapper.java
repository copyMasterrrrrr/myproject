package com.lin.dao;

import com.lin.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;

@Mapper
@Repository
public interface EmployeeMapper {
    public int add(Employee employee);

    public Collection<Employee> getEmployees();

    public  Employee getEmployeeById(Integer id);

    public int upd(Employee employee);

    public int deleteEmployee(@PathVariable("id") Integer id);
}
