package com.npci.emp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "employee")


public class Employee {
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_no")
	private Integer empno;
	@Column(name = "emp_name")
	private String ename;
	@Column(name = "job")
	private String job;
	@Column(name = "hiredate")
	private String hiredate;
	@Column(name = "manager_id")
	private Integer managerId;
	@Column(name = "salary")
	private Integer salary;
	@Column(name = "commission")
	private Integer commission;
	@Column(name = "dept_no")
	private Integer deptNo;
	public Employee() {
		super();
	}
	public Employee(Integer empNo, String eName, String job, String hireDate, Integer managerId, Integer salary,
			Integer commission, Integer deptNo) {
		super();
		this.empno = empNo;
		this.ename = eName;
		this.job = job;
		this.hiredate = hireDate;
		this.managerId = managerId;
		this.salary = salary;
		this.commission = commission;
		this.deptNo = deptNo;
	}
	public Integer getEmpNo() {
		return empno;
	}
	public void setEmpNo(Integer empNo) {
		this.empno = empNo;
	}
	public String geteName() {
		return ename;
	}
	public void seteName(String eName) {
		this.ename = eName;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getHireDate() {
		return hiredate;
	}
	public void setHireDate(String hireDate) {
		this.hiredate = hireDate;
	}
	public Integer getManagerId() {
		return managerId;
	}
	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public Integer getCommission() {
		return commission;
	}
	public void setCommission(Integer commission) {
		this.commission = commission;
	}
	public Integer getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(Integer deptNo) {
		this.deptNo = deptNo;
	}
	@Override
	public String toString() {
		return "Employee [empNo=" + empno + ", eName=" + ename + ", job=" + job + ", hireDate=" + hiredate
				+ ", managerId=" + managerId + ", salary=" + salary + ", commission=" + commission + ", deptNo="
				+ deptNo + "]";
	}
	
	


}
