package mbt.project.service;

import java.io.IOException;
import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import mbt.project.dao.Department_DAO;
import mbt.project.dao.Store_DAO;
import mbt.project.pojo.Store;

@Path("/store")
public class Store_Service {
	
	@Path("/ping")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String hello() {
		System.out.println("RESTful Service 'MessageService' is running ==> ping");
		return "received ping on " + new Date().toString();
	}
	
	
    @POST
    @Path("/add")
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_JSON)
    public String newStore(Store store) throws IOException {
    	Store_DAO dao = new Store_DAO();
		boolean result = dao.AddRecord(store);
		return "Added to DB => " + result;
    }

    @DELETE
    @Path("/delete/{id}")
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_JSON)
    public String removeStore(@PathParam("id") int id) throws IOException {
    	Store_DAO dao = new Store_DAO();
		boolean result = dao.DeleteRecord(id);
		return "Removed from DB => " + result;
    }

	
}
