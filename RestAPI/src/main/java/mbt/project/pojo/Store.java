package mbt.project.pojo;

import java.util.List;

/*
 *	 @author : Mehdi Ben Taarit
 */

public class Store {
	private String name;
	private String address;
	private List<Department> departments;
	
	public Store(String name, String address, List<Department> departments) {
		super();
		this.name = name;
		this.address = address;
		this.departments = departments;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<Department> getDepartments() {
		return departments;
	}
	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}
	@Override
	public String toString() {
		return "Store [name=" + name + ", address=" + address + ", departments=" + departments + "]";
	}
	
}
