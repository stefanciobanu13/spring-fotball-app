package com.teamsapp.springrest.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;


@Component
public class Team {
	
	//create a PlayersList object
	public PlayersList listObject = new PlayersList();
	
    public List<Player> thePlayers = listObject.getList();
    
    private double teamValue;
    
    @Transient
    public static int numberLimit = 24;
    
    @Transient
    public static ArrayList<Player> playersList = new ArrayList<Player>();

    public Team() {
    }



    public Team(double teamValue) {
		super();
		this.teamValue = teamValue;
	}


	public double getTeamValue() {
        return teamValue;
    }

    public void setTeamValue(double teamValue) {
        this.teamValue = teamValue;
    }
    
   
    // a method for adding a player from selecting the player to adding it and remove it from the list
    //the method gets the list of players, and after adding the player, the method updates the list and pass it back
    public void addPlayer(ArrayList<Player> theList) {
    	
    	if(playersList.size()==0) {			
    			matchLists(theList);
    	}
    	
    	if(this.numberLimit==0) {
    		this.numberLimit=24;
    	}
    	    	    	
    	//generate a random number   	
    	Random n1 = new Random();
    	int r1 = n1.nextInt(numberLimit);  	
    	
    	//get the random player 	
		Player player = playersList.get(r1);
		this.numberLimit = numberLimit - 1;
		
    	
    	//add the player only if the team is not complete and the value remains under 54 	
    	if(teamValue < 47 && thePlayers.size()<6 ) {
    	teamValue = teamValue + player.getGrade();
    	this.thePlayers.add(player);
    	
    	}
 		this.playersList.remove(player);
		    	
    }
    
   public void matchLists(ArrayList<Player> list) {
	   
	   this.playersList = (ArrayList<Player>)list.clone();   
   }
    
 
    public List<Player> getPlayers() {
 
    	return thePlayers;
    }


	@Override
	public String toString() {
		return "Team [thePlayers=" + thePlayers + ", teamValue=" + teamValue + "]";
	}
    
    
    
    
    
    
    
    
    
}

