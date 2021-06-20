package com.lin.controller;

import com.lin.dao.DepartmentMapper;
import com.lin.dao.EmployeeMapper;

import com.lin.pojo.Department;
import com.lin.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    DepartmentMapper departmentMapper;

    //员工管理页面
    @RequestMapping(value = "/emps")
    public String showEmployees(Model model){
        Collection<Employee> employees = employeeMapper.getEmployees();
        model.addAttribute("employees",employees);
        return "emp/list";
    }

    //跳转到员工添加页面
    @GetMapping("/toAddemp")
    public String toAddEmp(Model model){
        Collection<Department> departments = departmentMapper.getDepartments();
        System.out.println(departments);
        model.addAttribute("departments",departments);
        return "emp/addemp";
    }




    //添加员工
    @GetMapping("/addEmp")
    public String addEmp(Employee employee){
        employeeMapper.add(employee);
        return "redirect:/emps";
    }

    //去员工的修改页面
    @GetMapping("/toUpdEmp/{id}")
    public String toUpdEmp(@PathVariable("id") Integer id,Model model){
        //查出原来的数据
        Employee employee = employeeMapper.getEmployeeById(id);
        model.addAttribute("employee",employee);
        Collection<Department> departments = departmentMapper.getDepartments();
        model.addAttribute("departments",departments);
        System.out.println(employee);
        return "emp/updEmp";
    }

    //修改员工
    @RequestMapping("/updEmp")
    public String updEmp(Employee employee){
        employeeMapper.upd(employee);
        return "redirect:/emps";
    }

    //删除员工
    @GetMapping("/deleteEmp/{id}")
    public String deleteEmp(@PathVariable("id")Integer id){
        employeeMapper.deleteEmployee(id);
        return "redirect:/emps";
    }


    //注销功能
    @RequestMapping("/quit")
    public String quit(HttpSession httpSession){
        httpSession.invalidate();
        return "redirect:index.html ";
    }



}
