package com.mahendra.demo.models;

import javax.persistence.*;

@Entity
@Table(name="departments")
public class Department {
	
	@Id
	@SequenceGenerator(name="seq1",allocationSize=1,sequenceName="department_seq")
	@GeneratedValue(generator="seq1")
	@Column(name="department_id")
	private Integer deptId;
	
	@Column(name="department_name",length=30)
	private String name;
	
	@Column(name="manager_id")
	private Integer managerId;
	
	@Column(name="location_id")
	private Integer locationId;

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getManagerId() {
		return managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
