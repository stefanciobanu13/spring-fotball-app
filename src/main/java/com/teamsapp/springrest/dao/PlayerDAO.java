package com.teamsapp.springrest.dao;

import java.util.List;

import com.teamsapp.springrest.entity.Player;
import org.springframework.stereotype.Component;

@Component
public interface PlayerDAO {

	public void savePlayer(Player player);
	
	public List<Player> getPlayers();
	
	public Player getPlayer(int theId);
	
	public void deletePlayer(int theId);
	
	
	
}
