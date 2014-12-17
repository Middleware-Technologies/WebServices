package CLIENT.impl;

import CLIENT.generated.Player;
import CLIENT.generated.Team;
import CLIENT.generated.TeamService;
import CLIENT.generated.TeamServiceImplService;

public class TeamClient 
{
	public static void main(String[] args)
	{
		TeamServiceImplService service = new TeamServiceImplService();
		TeamService eif = service.getTeamServiceImplPort();
		printTeams(eif);
	}	
	private static void printTeams(TeamService eif)
	{
		for (Team team :eif.getTeams() )
		{
			System.out.println("Squadra: " + team.getName());
			for (Player p: team.getPlayers()){
				System.out.println("Nome: " + p.getName() +" Nickname: " + p.getNickname());
			}
		}
	}
}