/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RestfulWebServices;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.enterprise.context.RequestScoped;


/**
 * REST Web Service
 *
 * @author wilton
 */
@Path("Entry")
@RequestScoped
public class Point1 {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Point1
     */
    public Point1() {
    }

    /**
     * Retrieves representation of an instance of RestfulWebServices.Point1
     * @return an instance of java.lang.String
     */
    @GET
    //@Produces("application/JSON")
    @Produces("TEXT/Plain")
    public String getXml() {
        //TODO return proper representation object
        return "Hi There";
    }
    
    @POST
    @Produces("TEXT/Plain")
    public String PostXml(String message)
    {
        System.out.println(message);
        return "Hi There";
    }

    /**
     * PUT method for updating or creating an instance of Point1
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/xml")
    public void putXml(String content) {
    }
}
