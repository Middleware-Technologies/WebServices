package CLIENT.EXECUTE;

import java.util.Scanner;

import CLIENT.HelloWorld;
import CLIENT.HelloWorldImpService;

/*
 *  To generate client-code
 *	wsimport -keep -p PACKAGE -verbose -s POSITION WSDL
 *	example
 *	wsimport -keep -p client -verbose -s . http://....
 */

public class MainConsole 
{
	public static void main(String[] args) 
	{
		Scanner buf;
		try
		{
			buf = new Scanner (System.in);
			
			System.out.println("Tell me server name and server port");
			String name=buf.nextLine();
			String port=buf.nextLine();
			
			String webServiceUrl="http://"+name+":"+port+"/Server/Hello?wsdl";
			HelloWorldImpService.setUrl(webServiceUrl);
			
			HelloWorldImpService helloService=new HelloWorldImpService();
			HelloWorld hello=helloService.getHelloWorldImpPort();
							
			
			System.out.println("Tell me your name");
			String input=buf.nextLine();
			
			System.out.println("RESULT FROM WEB SERVICE:\n"+hello.sayHello(input));
		}
		catch(Exception e)
		{
			System.out.println("Errore: "+e.getCause());
		}		
	}
}