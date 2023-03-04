package com.teamsapp.springrest.service;

import java.util.List;

import com.teamsapp.springrest.entity.Player;

public interface PlayerService {

public void savePlayer(Player player);
	
	public List<Player> getPlayers();
	
	public Player getPlayer(int theId);
	
	public void deletePlayer(int theId);
	
	
	
}
