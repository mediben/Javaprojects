package mbt.project.app;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import mbt.project.pojo.Department;
import mbt.project.pojo.Employee;
import mbt.project.pojo.Store;

public class App {
	
	public static void main(String[] args) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		
		Date today = date;
		Float salaire = (float) 400.50;
		
		
		
		Employee employee = new Employee("Mehdi Ben Taarit", "9000 Aalborg", date , salaire, 0);
		List<Employee> emps = new ArrayList<Employee>();
		emps.add(employee);
		Department department = new Department("BedRoom", emps);
		List<Department> dps = new ArrayList<Department>();
		dps.add(department);
		Store store = new Store("Ikea", "Copenhaguen", dps);
	}
}
