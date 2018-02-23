package dataproces.sikkerhedsstyrelsen.api.rest;

import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dataproces.sikkerhedsstyrelsen.api.dao.Applicant_dao;
import dataproces.sikkerhedsstyrelsen.api.pojo.ApplicantObj;

@Path("/applicant")
public class ApplicantService {
	
	@Path("/ping")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String hello() {
		System.out.println("RESTful Service 'MessageService' is running ==> ping");
		return "received ping on " + new Date().toString();
	}

	@GET
	@Path("/getlast")
	//@Produces(MediaType.TEXT_HTML)
	@Produces(MediaType.APPLICATION_JSON)
	public ApplicantObj getApplicant() {
		Applicant_dao dao = new Applicant_dao();
		ApplicantObj result = dao.getLast();
		return result;
	}
	
}
