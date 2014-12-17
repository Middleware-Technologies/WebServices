package server.team;

import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class TeamsUtility 
{
    private Map<String, Team> team_map;

    public TeamsUtility() 
    {
    	team_map = new HashMap<String, Team>();
    	make_test_teams();
    }

    public Team getTeam(String name) 
    {
    	return team_map.get(name);
    }

    public List<Team> getTeams() 
    {
		List<Team> list = new ArrayList<Team>();
		Set<String> keys = team_map.keySet();
		for (String key : keys)
		    list.add(team_map.get(key));
		return list;
    }

    public void make_test_teams() 
    {
		List<Team> teams = new ArrayList<Team>();
	
		Player balo = new Player("Mario Balotelli", "Balo");
		Player kaka = new Player("Kaka", "Smoking Bianco");
		List<Player> ba = new ArrayList<Player>();
		ba.add(balo); ba.add(kaka);
		Team milan = new Team("Milan", ba);
		teams.add(milan);
	
		Player milito = new Player("Diego Milito", "El Principe");
		Player samuel = new Player("Walter Samuel", "The wall");
		List<Player> ac = new ArrayList<Player>();
		ac.add(milito); ac.add(samuel);
		Team inter = new Team("Inter", ac);
		teams.add(inter);
	
		Player alex = new Player("Alessandro Del Piero", "Pinturicchio");
		Player gigi = new Player("Gigi Buffon", "Superman");	
		List<Player> mb = new ArrayList<Player>();
		mb.add(alex); mb.add(gigi); 
		Team juve = new Team("Juve", mb);
		teams.add(juve);
	
		store_teams(teams);
    }

    private void store_teams(List<Team> teams) 
    {
    	for (Team team : teams)
    		team_map.put(team.getName(), team);
    }
}