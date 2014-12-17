package client.impl;

import client.Info;
import client.InfoSoapType;
import client.TPlayerNames;

public class EuroCupClient 
{
	public static void main(String[] args)
	{
		Info service = new Info();
		InfoSoapType eif = service.getInfoSoap();
		
		System.out.println("printing all the cities: " );
		
		for (String city : eif.cities().getString())
		{
			System.out.println(city);
		}
		
		System.out.println("Players:");
		for (TPlayerNames pl : eif.allPlayerNames(false).getTPlayerNames())
		{
			
			System.out.println(pl.getSName());
		}
		
		System.out.println("Italian Strikers:");
		for (String fw : eif.fullTeamInfo("Italy").getSForwards().getString() )
		{
			System.out.println(fw);
		}
	}
}