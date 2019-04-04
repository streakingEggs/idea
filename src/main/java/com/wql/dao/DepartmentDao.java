package com.wql.dao;

import com.wql.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DepartmentDao extends JpaRepository<Department,Integer>, JpaSpecificationExecutor<Department> {
}
