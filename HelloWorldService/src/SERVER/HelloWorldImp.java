package SERVER;

import javax.jws.WebService;

@WebService(endpointInterface="SERVER.HelloWorld")
public class HelloWorldImp implements HelloWorld 
{
	private String message;
	
	public HelloWorldImp(String mess) {
		// TODO Auto-generated constructor stub
		this.message=mess;
	}
	
	@Override
	public String sayHello(String name) 
	{
		return "Nome Client:"+name+"\nMessage:"+this.message;
	}
}