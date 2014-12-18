package server.deploy;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.xml.ws.Endpoint;

import server.impl.ImageWSImpl;

public class Publisher 
{
	public static void main(String[] args) throws UnknownHostException 
	{
		String position="C:/Users/Luca/Desktop/";
		ImageWSImpl.Setting(position);
		
		String host=InetAddress.getLocalHost().getHostName();
		int port= 9999;
		
		Endpoint.publish("http://"+host+":"+port+"/ImageWS", new ImageWSImpl());
		System.out.println("ImageWS has been deployed");
	}
}