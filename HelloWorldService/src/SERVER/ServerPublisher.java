package SERVER;

import java.net.InetAddress;
import javax.xml.ws.Endpoint;

public class ServerPublisher 
{
	public static void main(String[] args)
	{			
		try
		{
			String host=InetAddress.getLocalHost().getHostName();
			String port = "8085";
			String url = "http://"+host+":"+port+"/Server/Hello";
			
			Endpoint.publish(url, new HelloWorldImp("Ciao"));
			System.out.println("Web Services Created");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}