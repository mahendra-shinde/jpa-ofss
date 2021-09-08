package com.mahendra;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

@Entity
@Table(name="departments")

public class Department implements Serializable {

	@Id
	@Column(name="dept_no",length=4)
	private String deptId;
	
	@Column(name="dept_name",length=40)
	private String name;
	private static final long serialVersionUID = 1L;

	public Department() {
		super();
	}   
	public String getDeptId() {
		return this.deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
   
}
