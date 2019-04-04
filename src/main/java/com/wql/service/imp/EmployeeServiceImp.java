package com.wql.service.imp;

import com.wql.dao.EmployeeDao;
import com.wql.model.Employee;
import com.wql.query.EmployeeQuery;
import com.wql.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    EmployeeDao employeeDao;

    @Override
    public Page<Employee> getAll(EmployeeQuery employeeQuery, Pageable pageable) {
        return employeeDao.findAll(employeeQuery,pageable);
    }

}
