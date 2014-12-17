package server.deploy;

import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.xml.ws.Endpoint;
import server.service.TeamServiceImpl;

class TeamsPublisher 
{
    public static void main(String[ ] args) throws UnknownHostException 
    {
       int port = 8888;
       String host= InetAddress.getLocalHost().getHostName();
       String url = "http://"+host+":"+port+"/teams";
            
       System.out.println("Publishing Teams on port: " + port);
       Endpoint.publish(url, new TeamServiceImpl());
    }
} 