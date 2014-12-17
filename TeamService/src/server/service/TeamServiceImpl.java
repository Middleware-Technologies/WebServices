package server.service;

import java.util.List;

import javax.jws.WebService;

import server.team.Team;
import server.team.TeamsUtility;

@WebService(endpointInterface = "server.service.TeamService")
public class TeamServiceImpl implements TeamService
{
    private TeamsUtility utils;

    public TeamServiceImpl() 
    { 
       utils = new TeamsUtility(); 
       utils.make_test_teams();
    }

    public Team getTeam(String name) { return utils.getTeam(name); }
    public List<Team> getTeams() { return utils.getTeams(); }
}