package it.polimi.mw.rest.images.backend;

import it.polimi.mw.rest.images.formats.Image;
import it.polimi.mw.rest.images.formats.ImageContainer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class ImageStorage {
	
	public static ImageStorage IS = new ImageStorage();
	
	private HashMap<String, byte[]> images = new HashMap<String, byte[]>(); 
	
	private String partialURI = "http://localhost:9999/myapp/imageContainer/";
	
	public ImageStorage() {
		// TODO Auto-generated constructor stub
	}
	
	public byte[] getImage(String name) {
		return images.get(name);
	}
	
	public void addImage(String name, byte[] b) {
		images.put(name, b);
	}

	public ImageContainer getImageContainer() {

		if (images.keySet().isEmpty()) {
			return new ImageContainer();
		}
		else {
			Set<String> names = images.keySet();
			Iterator<String> i = names.iterator();
			System.out.println("Found " + images.keySet().size() + " names.");
			Image[] imageArray = new Image[images.keySet().size()];
			int j=0;
			while(i.hasNext()) {
				String n = i.next();
				imageArray[j] = new Image(n, this.partialURI+n);
				j++;
			}
			return new ImageContainer(imageArray);
		}
	}

	public void removeImage(String imageName) {
		// TODO Auto-generated method stub
		this.images.remove(imageName);
	}
	
	

}
