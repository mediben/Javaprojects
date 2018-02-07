package mbt.project.pojo;

import java.util.List;

/*
 *	 @author : Mehdi Ben Taarit
 */

public class Department {

	private String name;
	private Employee supervisor;
	private List<Employee> employees;
	
	public Department(String name, Employee supervisor, int employeesNumber, List<Employee> employees) {
		super();
		this.name = name;
		this.supervisor = supervisor;
		this.employees = employees;
	}
	
	public Employee getSupervisor() {
		return supervisor;
	}
	public void setSupervisor(Employee supervisor) {
		this.supervisor = supervisor;
	}
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Employee> getEmployee() {
		return employees;
	}
	public void setEmployee(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Department [name=" + name + ", supervisor=" + supervisor + ", employees=" + employees + "]";
	}
}
