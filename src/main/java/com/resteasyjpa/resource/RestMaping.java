package com.resteasyjpa.resource;

import javax.persistence.EntityManager;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.inject.Inject;


@Path("/hello")
public class RestMaping {
	
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
  
	/*@POST
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addStudent() {
		Student st = new Student();
		st.setId(1);
		st.setName("parvej");
		st.setDepartment("backend");
		st.setCity("surat");
		return Response.ok().entity(st).build();
		
	}
	
	@POST
	@Path("/addResource")    
	public Response addDetails(@FormParam("name") String name, @FormParam("city") String city) {
		return Response.ok().entity(" name : " + name + " city : " + city).build();
	}*/
	
}
