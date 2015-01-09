package com.example;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

@Path("hello")
public class Greeting {
    
	@Context
    private UriInfo context;
    
    /**
     * Default constructor. 
     */
    public Greeting() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Retrieves representation of an instance of Greeting
     * @return an instance of String
     */
    @GET
    @Produces("application/xml")
    public String getXml() {	
    		return "<greeting> Hello !!! </greeting>";
 
    }
    
    /**
     * Retrieves representation of an instance of Greeting
     * @return an instance of String
     */
    @GET
    @Produces("text/html")
    public String getHTML() {	
    		return "<h3> Hello !!! </h3>";
 
    }


}