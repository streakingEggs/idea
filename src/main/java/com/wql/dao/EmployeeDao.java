package com.wql.dao;

import com.wql.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EmployeeDao extends JpaRepository<Employee,Integer>, JpaSpecificationExecutor<Employee> {
}
