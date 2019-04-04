package com.wql.service.imp;

import com.wql.dao.DepartmentDao;
import com.wql.model.Department;
import com.wql.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImp implements DepartmentService {

    @Autowired
    DepartmentDao departmentDao;

    @Override
    public List<Department> getAll() {
        return departmentDao.findAll();
    }
}
