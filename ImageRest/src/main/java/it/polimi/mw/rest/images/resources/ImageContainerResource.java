package it.polimi.mw.rest.images.resources;

import it.polimi.mw.rest.images.backend.ImageStorage;
import it.polimi.mw.rest.images.formats.ImageContainer;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

@Path("/imageContainer")
public class ImageContainerResource {
	
	@Context UriInfo uriInfo;

	@Path("{imageName}")
	public ImageResource getImageResource(@PathParam(value="imageName") String imageName) {
		return new ImageResource(uriInfo, imageName);
		
	}
	
	@GET
	public ImageContainer getContainer() {
		return ImageStorage.IS.getImageContainer();
		
	}
	

}
