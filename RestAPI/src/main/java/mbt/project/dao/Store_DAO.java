package mbt.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import mbt.project.pojo.Department;
import mbt.project.pojo.Store;

public class Store_DAO {

	
	Connect database = new Connect();
	Connection conect = database.getConnection();
		
	public boolean AddRecord(Store store) {
		boolean res =false;
		PreparedStatement ps = null;
		try {
			ps = conect.prepareStatement("INSERT INTO disciplinedapproach.organisation_store (name, address)"
					+ " VALUES ('"+store.getName()+"','"+store.getAddress()+"')");
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
				try {
					ps.close();
				} catch (SQLException e1) {
					e1.printStackTrace();}
			try {
				conect.close();
				res = true;
			} catch (SQLException e) {
				e.printStackTrace();}
		}
		return res;
	}
	
	public boolean DeleteRecord(int id) {
		boolean res = false;
		PreparedStatement ps = null;
		try {
			ps = conect.prepareStatement("Delete FROM disciplinedapproach.organisation_store WHERE id ="+id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e1) {
				e1.printStackTrace();}
		try {
			conect.close();
			res = true;
		} catch (SQLException e) {
			e.printStackTrace();}
	}
		return res;
	}
	
	public boolean EditRecord() {
		
		return true;
	}
	
	public List<Department> GetAll() {
		
		return null;
	}
	
	public Department Getit() {
		
		return null;
	}
	
}
