package server.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import server.team.Team;

@WebService
public interface TeamService 
{
	 @WebMethod
	 public Team getTeam(String name);
	 
	 @WebMethod
	 public List<Team> getTeams();
}