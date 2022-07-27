package com.empmng.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.empmng.entities.Employee;

@Repository
public interface EmpRepo extends JpaRepository<Employee, Integer> {

	Employee findByEmail(String username);

}
