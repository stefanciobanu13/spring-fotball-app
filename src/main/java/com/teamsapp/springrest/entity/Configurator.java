package com.teamsapp.springrest.entity;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class Configurator {

	public Team team1 = new Team();
	public Team team2= new Team();
	public Team team3= new Team();
	public Team team4= new Team();
	public ArrayList<Player> playersList;

	public double standardDeviation;
	public double[] teamsValues = new double[4];
	
	
	public void configureTeams(ArrayList<Player> List) {
				 	
		ArrayList<Player> theList =(ArrayList<Player>)List.clone();	
		
		//doing the first version of teams
		while(team4.thePlayers.size()<6) {
			 team1.addPlayer(theList);
		     team2.addPlayer(theList);
			 team3.addPlayer(theList);		
			 team4.addPlayer(theList);	
			
		}	
		
		//storing the values of the teams
		teamsValues[0]=team1.getTeamValue();
		teamsValues[1]=team2.getTeamValue();
		teamsValues[2]=team3.getTeamValue();
		teamsValues[3]=team4.getTeamValue();
		
		//calculate the standard deviation of the teams values
		 double stdDev = StandardDeviation.calculateSD(teamsValues);
		 this.standardDeviation=stdDev;
		 
		 //call the method that will improve the teams
		 generateTeams(List);
	}
	
		
	public void generateTeams(ArrayList<Player> List) {
		
		ArrayList<Player> theList = List;
		boolean teamsComplete = false;	
		
		//allocate players to the teams as long as the teams are not complete and standard deviation is not reached
			while(this.standardDeviation>0.5 || teamsComplete == false) {
				
				//empty the teams if the standard deviation is not reached
				if(team4.thePlayers.size()==6) {
					resetTeams();
					teamsComplete = false;
				}	
				
			 team1.addPlayer(List);		
			 team2.addPlayer(List);
			 team3.addPlayer(List);
			 team4.addPlayer(List);	
			 
			//update the values of the teams
			teamsValues[0]=team1.getTeamValue();
			teamsValues[1]=team2.getTeamValue();
			teamsValues[2]=team3.getTeamValue();
			teamsValues[3]=team4.getTeamValue();
			
			//recalculate the standard deviation
			 double stdDev = StandardDeviation.calculateSD(teamsValues);
			 this.standardDeviation=stdDev;
			 if(team4.thePlayers.size()==6) {
				 teamsComplete = true;
			 }
			
		}	
	}
	
	public void resetTeams() {
		//empty the teams
		this.team1 = new Team();
		this.team2 = new Team();
		this.team3 = new Team();
		this.team4 = new Team();	
	}
		

	public Team getTeam1() {
		return team1;
	}


	public Team getTeam2() {
		return team2;
	}


	public Team getTeam3() {
		return team3;
	}


	public Team getTeam4() {
		return team4;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void setTeam1(Team team1) {
		this.team1 = team1;
	}



	public void setTeam2(Team team2) {
		this.team2 = team2;
	}



	public void setTeam3(Team team3) {
		this.team3 = team3;
	}



	public void setTeam4(Team team4) {
		this.team4 = team4;
	}



	public double getStandardDeviation() {
		return standardDeviation;
	}

	public Configurator() {}
	

	
	
	
	
	
	
}
