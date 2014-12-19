package server.impl;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.jws.WebService;
import javax.xml.ws.soap.MTOM;

import server.ImageWS;

@WebService(endpointInterface="server.ImageWS")
@MTOM(enabled=true, threshold=2000)              //Trasferimento file binari

public class ImageWSImpl implements ImageWS 
{
	static String urlImage;
	
	public static void Setting(String url) 
	{
		urlImage=url;
	}
	
	@Override
	public String uploadImage(Image data, String name)  //SEND IMAGE FROM CLIENT TO SERVER
	{
		if (data!=null) 
		{	
			try 
			{
				BufferedImage bImage = new BufferedImage(data.getWidth(null), data.getHeight(null), BufferedImage.TYPE_INT_RGB);
				Graphics2D graphics = bImage.createGraphics();
				graphics.drawImage(data, null, null);
				RenderedImage rImage = (RenderedImage)bImage;
				ImageIO.write(rImage, "jpg", new File(urlImage+"Received" + name));
				return "Upload Success";
			} catch (IOException e) {}
			return "Upload Error";
		}
		return "Data was null";
	}

	@Override
	public Image downloadImage(String name)   //SEND IMAGE FROM SERVER TO CLIENT
	{
		Image returnImage = null;
		try 
		{
			String pathCompleto=urlImage+name;
			returnImage = ImageIO.read(new File(pathCompleto));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return returnImage;
	}
}