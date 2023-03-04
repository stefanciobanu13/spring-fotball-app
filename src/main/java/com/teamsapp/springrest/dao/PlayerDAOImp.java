package com.teamsapp.springrest.dao;

import java.util.List;

import com.teamsapp.springrest.entity.Player;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class PlayerDAOImp implements PlayerDAO {


	@Autowired
	public SessionFactory sessionFactory;

	@Override
	public void savePlayer(Player player) {

		Session currentSession = sessionFactory.getCurrentSession();

		currentSession.saveOrUpdate(player);
		
	}
	
	
	@Override
	public List<Player> getPlayers() {

		
//get the current hibernate session

Session currentSession = sessionFactory.getCurrentSession();

//create a query

Query<Player> theQuery = currentSession.createQuery("from Player order by id ",Player.class);

//execute query and get result list

List<Player> players = theQuery.getResultList();


	//return the result
	return players;
	}


	@Override
	public void deletePlayer(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Player tempPlayer = currentSession.get(Player.class, theId);
		
		currentSession.remove(tempPlayer);

	}

	@Override
	public Player getPlayer(int theId) {

		Session currentSession = sessionFactory.getCurrentSession();

		Player tempPlayer = currentSession.get(Player.class, theId);
		
		return tempPlayer;
	}












	
	
	
	
	
	
	
}
