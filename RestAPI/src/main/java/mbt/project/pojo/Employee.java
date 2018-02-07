package mbt.project.pojo;

import java.util.Date;

import mbt.project.enums.Status;
import mbt.project.enums.Title;

/*
 *	 @author : Mehdi Ben Taarit
 */

public class Employee {
	
	private Title title;
	private String fullname;
	private String address;
	private Date employeeSince;
	private float salary;
	private int alerts;
	private Status status;
	
		
	public Employee(String fullname, String address, Date employeeSince, float salary, int alerts) {
		super();
		this.fullname = fullname;
		this.address = address;
		this.employeeSince = employeeSince;
		this.salary = salary;
		this.alerts = alerts;
	}
	public Title getTitle() {
		return title;
	}
	public void setTitle(Title title) {
		this.title = title;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getEmployeeSince() {
		return employeeSince;
	}
	public void setEmployeeSince(Date employeeSince) {
		this.employeeSince = employeeSince;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public int getAlerts() {
		return alerts;
	}
	public void setAlerts(int alerts) {
		this.alerts = alerts;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "RecordFile [fullname=" + fullname + ", address=" + address + ", employeeSince=" + employeeSince
				+ ", salary=" + salary + ", alerts=" + alerts + "]";
	}

}
