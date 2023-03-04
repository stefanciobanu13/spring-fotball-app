package com.teamsapp.springrest.service;

import java.util.List;

import javax.transaction.Transactional;

import com.teamsapp.springrest.dao.PlayerDAO;
import com.teamsapp.springrest.entity.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class PlayerServiceImp implements PlayerService {

	@Autowired
	private PlayerDAO playerDAO;


	@Override
	@Transactional
	public void savePlayer(Player player) {
	
		playerDAO.savePlayer(player);
		
	}

	@Override
	@Transactional
	public List<Player> getPlayers() {
		
	
		return playerDAO.getPlayers();
	}

	@Override
	@Transactional
	public Player getPlayer(int theId) {

		
		return playerDAO.getPlayer(theId);
	}

	@Override
	@Transactional
	public void deletePlayer(int theId) {

		playerDAO.deletePlayer(theId);
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
