package com.lin.dao;
import com.lin.pojo.Department;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Collection;
@Mapper
@Repository
public interface DepartmentMapper {
    //获取所有部门信息
    public Collection<Department> getDepartments();
    //根据部门id查询部门
    public Department getDepartmentById(Integer id);
}
