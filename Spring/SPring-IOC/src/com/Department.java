package com;

import org.springframework.stereotype.Component;

@Component
public class Department {

	private int deptId=10;
	private String deptName="HR";
	
	public Department() {
		System.out.println("-- Dept Obj created");
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

}
