package com.teamsapp.springrest.rest;


import com.teamsapp.springrest.entity.Player;
import com.teamsapp.springrest.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {


    @Autowired
    private PlayerService playerService;


    @GetMapping("/players")
    public List<Player> getPlayers(){



        return playerService.getPlayers();
    }


    @GetMapping("/players/{playerId}")
    public Player getPlayer(@PathVariable int playerId){


    return playerService.getPlayer(playerId);
    }

    @DeleteMapping("/players/{playerId}")
    public String deletePlayer(@PathVariable int playerId){

        playerService.deletePlayer(playerId);

        return "The player with the id" + " " + playerId + " " + " was deleted";
    }

    @PutMapping("/players")
    public String updatePlayer(@RequestBody Player thePlayer){

      playerService.savePlayer(thePlayer);

              return "The player with the id " + " " + thePlayer.getId() +  " " + " was updated";
    }






}
