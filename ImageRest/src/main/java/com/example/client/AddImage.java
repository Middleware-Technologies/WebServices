package com.example.client;

import java.io.File;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class AddImage {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Client client= Client.create();
			WebResource webResource= client.resource("http://localhost:9999/myapp/imageContainer");
			System.out.println("Adding Chuck ...");
			File imgFile = new File("chuck.jpg");	
			webResource.path("chuck").type("image/jpeg").put(imgFile);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

}
