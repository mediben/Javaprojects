package dataproces.sikkerhedsstyrelsen.api.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dataproces.sikkerhedsstyrelsen.api.pojo.ApplicantObj;

public class Applicant_dao {


	static final String URL = "jdbc:mysql://Mariadb:3306/db_name";
	static final String USER = "db_usernam";
	static final String PASSWORD = "db_password";
	static final String DRIVER = "com.mysql.jdbc.Driver";

	public Connection getConnection() throws SQLException {
		Connection con = null;
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			System.out.println("Cannot establish conenction to DB ! \n " + e.getMessage());
			System.exit(-1);
		}
		return con;
	}

	// Get all Applicant
	public List<ApplicantObj> getAll() {
		ResultSet rs = null;
		List<ApplicantObj> applicants = new ArrayList<ApplicantObj>();
		try {
			Statement s = getConnection().createStatement();
			rs = s.executeQuery("SELECT * FROM applicant ORDER BY ID DESC LIMIT 1");
			try {
				while (rs.next()) {
					System.out.println("=> "+rs.getString("fullName"));
					ApplicantObj applicant = new ApplicantObj();
					
					applicant.setFullName(rs.getString("fullName"));
					applicant.setPrivateAddress(rs.getString("PrivateAddress"));
					applicant.setZipCode(rs.getString("ZipCode"));
					applicant.setCity(rs.getString("City"));
					applicant.setCountry(rs.getString("Country"));
					applicant.setMobileNumber(rs.getString("MobileNumber"));
					applicant.setEmailAddress(rs.getString("EmailAddress"));
					applicant.setPyroNumber(rs.getString("PyroNumber"));
					applicant.setPassportFilePath(rs.getString("PassportFilePath"));
					applicant.setHasCertificate(rs.getBoolean("HasCertificate"));
					applicant.setCvOrCertificateFilePath(rs.getString("CvOrCertificateFilePath"));
					applicant.setIsEducated(rs.getBoolean("IsEducated"));
					applicant.setInsuranceFilePath(rs.getString("InsuranceFilePath"));
					applicant.setStatus(rs.getBoolean("Status"));
					applicant.setSceneFireworker(rs.getBoolean("SceneFireworker"));
					applicants.add(applicant);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e) {
			System.out.println("Error **** \n"+e.getMessage());
			System.exit(-1);
		}
		return applicants;
	}

	// get last input
	public ApplicantObj getLast() {
		ResultSet rs = null;
		ApplicantObj applicant = new ApplicantObj();
		try {
			Statement s = getConnection().createStatement();
			rs = s.executeQuery("SELECT * FROM applicant ORDER BY ID DESC LIMIT 1");
			if (rs.next()) {
				applicant.setFullName(rs.getString("fullName"));
				applicant.setPrivateAddress(rs.getString("PrivateAddress"));
				applicant.setZipCode(rs.getString("ZipCode"));
				applicant.setCity(rs.getString("City"));
				applicant.setCountry(rs.getString("Country"));
				applicant.setMobileNumber(rs.getString("MobileNumber"));
				applicant.setEmailAddress(rs.getString("EmailAddress"));
				applicant.setPyroNumber(rs.getString("PyroNumber"));
				applicant.setPassportFilePath(rs.getString("PassportFilePath"));
				applicant.setHasCertificate(rs.getBoolean("HasCertificate"));
				applicant.setCvOrCertificateFilePath(rs.getString("CvOrCertificateFilePath"));
				applicant.setIsEducated(rs.getBoolean("IsEducated"));
				applicant.setInsuranceFilePath(rs.getString("InsuranceFilePath"));
				applicant.setStatus(rs.getBoolean("Status"));
				applicant.setSceneFireworker(rs.getBoolean("SceneFireworker"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.exit(-1);
		}
		return applicant;
	}

	// Add new record
	public void Add() {

	}

	// Delete record
	public void delete() {

	}


}
