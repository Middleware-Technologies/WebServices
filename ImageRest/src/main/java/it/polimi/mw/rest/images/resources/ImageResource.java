package it.polimi.mw.rest.images.resources;

import it.polimi.mw.rest.images.backend.ImageStorage;

import java.net.URI;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Produces("image/jpeg")
public class ImageResource {

	UriInfo uriInfo;
	String imageName;
	
	public ImageResource(UriInfo uriInfo, String imageName) {
		// TODO Auto-generated constructor stub
		this.uriInfo = uriInfo;
		this.imageName = imageName;
	}
	
	@GET
	public Response getImage() {	
		System.out.println("Received request with imageName: " + imageName);
		byte[] b = ImageStorage.IS.getImage(imageName);
		return Response.ok(b).build();
		
	}
	
	@PUT
	public Response putImage(@Context HttpHeaders headers, byte[] data){	
		System.out.println("Received media type: " + headers.getMediaType().getType() + " with imageName " + imageName);
		ImageStorage.IS.addImage(imageName, data);
		URI uri = uriInfo.getAbsolutePath();
		return Response.created(uri).build();
	}
	
	@DELETE
	public Response deleteImage() {
		ImageStorage.IS.removeImage(imageName);
		return Response.ok().build();
	}

}
