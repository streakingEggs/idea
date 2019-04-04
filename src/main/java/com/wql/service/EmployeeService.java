package com.wql.service;

import com.wql.model.Employee;
import com.wql.query.EmployeeQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {

    Page<Employee> getAll(EmployeeQuery employeeQuery, Pageable pageable);
}
