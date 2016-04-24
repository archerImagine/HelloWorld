package com.cisco.cmad;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.cisco.cmad.model.BlogUser;
import com.cisco.cmad.repository.BlogUserRepository;
import com.cisco.cmad.repository.BlogUserRepositoryStub;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class BlogResource {
	private BlogUserRepository blogUserRepository = new BlogUserRepositoryStub();

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
/*    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
*/    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<BlogUser> getAllUser(){
		return blogUserRepository.findAllUsers();
    }
    @POST
	@Path("activity")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public BlogUser create(BlogUser blogUser){
    	System.out.println("BlogResource.create() : " +blogUser.getEmail());
    	System.out.println("BlogResource.create() : " +blogUser.getPassword());
    	System.out.println("BlogResource.create() : " +blogUser.getUserName());
    	
    	blogUserRepository.create(blogUser);
    	
		return blogUser;
    }
    
    @POST
	@Path("login")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getAuthentication(MultivaluedMap<String, String> formParam){
    	System.out.println("BlogResource.getAuthentication() " +formParam.getFirst("username"));
    	System.out.println("BlogResource.getAuthentication() " +formParam.getFirst("password"));
    	
    	boolean isOk =  blogUserRepository.authenticate(formParam);
    	
    	if (isOk) {
			return Response.status(Status.OK).build();
		}else{
			return Response.status(Status.BAD_REQUEST).build();
		}
    	
    }
    @GET
    @Path("description")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response searchForDescription(@QueryParam(value = "description") String description){
    	System.out.println("BlogResource.searchForDescription()" +description);
    	
    	String textResponse = blogUserRepository.findByDescription(description);
    	System.out.println("BlogResource.searchForDescription()" +textResponse);
    	if (textResponse != null) {
    		System.out.println("BlogResource.searchForDescription() 1111" );
			// return Response.ok().entity(textResponse).build();
    		return Response.status(Status.OK).build();
		}else{
			System.out.println("BlogResource.searchForDescription() 2222");
			return Response.status(Status.BAD_REQUEST).build();
		}
    }
}
