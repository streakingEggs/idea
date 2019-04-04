package com.wql.controller;

import com.wql.model.Department;
import com.wql.model.Employee;
import com.wql.query.EmployeeQuery;
import com.wql.service.DepartmentService;
import com.wql.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    DepartmentService departmentService;

    @RequestMapping("/getAll")
    public String getAll(Model model, EmployeeQuery query, @PageableDefault(size = 5)Pageable pageable){
        Page<Employee> page = employeeService.getAll(query, pageable);
        List<Department>deparList=departmentService.getAll();


        model.addAttribute("page",page);
        model.addAttribute("query",query);
        model.addAttribute("empList",page.getContent());
        model.addAttribute("deparList",deparList);
        return "emp/list";
    }


}
