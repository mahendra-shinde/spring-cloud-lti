package com.mahendra.demo.daos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mahendra.demo.models.Department;


@Repository
public interface DepartmentDAO extends CrudRepository<Department, Integer>{
	
	
	@Query("select d from Department d")
	public List<Department> findAll();
}
