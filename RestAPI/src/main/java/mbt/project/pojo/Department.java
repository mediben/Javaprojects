package mbt.project.pojo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 *	 @author : Mehdi Ben Taarit
 */

@Entity
@Table(name="department")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	
	
	private List<Employee> employees;
	
	public Department(String name, List<Employee> employees) {
		super();
		this.name = name;
		this.employees = employees;
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
		return "Department [name=" + name + ", employees=" + employees + "]";
	}
}
