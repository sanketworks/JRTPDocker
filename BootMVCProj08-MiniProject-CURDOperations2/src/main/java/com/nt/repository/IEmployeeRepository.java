package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.EmployeeEntity;

public interface IEmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {

}
