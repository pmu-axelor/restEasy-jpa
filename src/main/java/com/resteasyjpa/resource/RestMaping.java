package com.resteasyjpa.resource;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.plugins.providers.html.View;

import com.google.gson.Gson;
import com.google.inject.Inject;
import com.resteasyjpa.entity.Category;
import com.resteasyjpa.entity.Expenses;
import com.resteasyjpa.service.ServiceClas;

@Path("/hello")
public class RestMaping {
	
	
	
	@Inject
	ServiceClas serviceClas;
	
	@Inject
	EntityManager em;
	
	@GET
	@Path("/something")
	public String saySomething() {
		return "hi parvej welcome to resteasy learning";
	}
	
	
	@GET
	@Path("/helo/{name}")
	public String sayHello(@PathParam("name") String msg) {
		return msg;
	}
	
	@GET
	@Path("/hi")
	public Response sayHi() {
		String msg = "this is using Response return type";
		return Response.ok().entity(msg).build();
	}
  
	@POST
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addStudent() {
		Expenses ex = new Expenses();
		ex.setAmount(10000);
		return Response.ok().entity(ex).build();
		
	}
	
	@GET
	public View getDetails(@Context HttpServletResponse response,
	@Context HttpServletRequest request){

		Query query = em.createQuery("Select e from Expenses e");
		List result = query.getResultList();
	    request.setAttribute("data", result);
	    return new View("index.jsp");
	
	}
	
	@POST
	@Path("/addExpenses")  
	public void addDetails( @Context HttpServletRequest req,@Context HttpServletResponse resp,
			@FormParam("amt") int amount, @FormParam("edate") String dateField) throws  ServletException, IOException, ParseException {
		
		     serviceClas.createExpenses(amount,dateField);
		   
			 resp.sendRedirect(req.getContextPath() + "/hello");
			
	}
	
	@GET
	@Path("/delete")
	public void deleteDetails(@Context HttpServletRequest req,@Context HttpServletResponse resp,
			@QueryParam("id") Long id) throws IOException, ServletException {
			serviceClas.deleteDetails(id);
		
		resp.sendRedirect(req.getContextPath() + "/hello");
		
	}
   
	@GET
	@Path("/dropDown")
	@Produces(MediaType.APPLICATION_JSON)
	public List getcategory(@Context HttpServletResponse response,
	@Context HttpServletRequest request) throws ServletException, IOException{

		Query query = em.createQuery("Select c from Category c");
		List result = query.getResultList();
		return result;
	}
	
	@POST
	@Path("/addCategory")
	 public void addCategoryDetails(@Context HttpServletRequest req,@Context HttpServletResponse resp,
			@FormParam("name") String name) throws IOException {
		serviceClas.createCategory(name);
		resp.sendRedirect(req.getContextPath() + "/hello");
	}
	

}
