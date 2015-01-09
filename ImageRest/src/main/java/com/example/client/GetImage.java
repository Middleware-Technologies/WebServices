package com.example.client;

import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class GetImage {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Client client= Client.create();
		WebResource webResource= client.resource("http://localhost:9999/myapp/imageContainer/sarah");
		
		byte[] bytes = webResource.accept("image/jpeg").get(byte[].class);
		System.out.println("Downloaded " + bytes.length + "bytes");
		
		InputStream in = new ByteArrayInputStream(bytes);
        Image image = null;
		try {
			image = ImageIO.read(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
        //display it in frame
        JFrame frame = new JFrame();
        frame.setSize(1280, 1024);
        JLabel label = new JLabel(new ImageIcon(image));
        frame.add(label);
        frame.setVisible(true);
		
		
	}

}
