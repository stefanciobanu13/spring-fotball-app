package com.teamsapp.springrest.entity;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class PlayersList {


	private ArrayList<Player> list = new ArrayList<Player>();
	

	public ArrayList<Player> getList() {
		return list;
	}

	public void setList(ArrayList<Player> list) {
		this.list = list;
	}

	public PlayersList(){}

	public PlayersList(ArrayList<Player> list) {
		super();
		this.list = list;
	}

  
	
	
	
	
	
	
	
}
