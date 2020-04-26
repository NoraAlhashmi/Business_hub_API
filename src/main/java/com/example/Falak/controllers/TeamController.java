package com.example.Falak.controllers;

import com.example.Falak.model.Team;
import com.example.Falak.services.TeamServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    private TeamServices teamServices;

    @GetMapping
    public List<Team> getTeams(){
        return teamServices.getAllTeams();
    }

    @GetMapping("/{id}")
    public Team getTeam (@PathVariable int id){
        return teamServices.getTeam(id);
    }

    @PostMapping
    public void addTeam(@Valid @RequestBody Team team){
        teamServices.addTeam(team);
    }

    @PutMapping("/{id}")
    public void updateTeam(@RequestBody Team team, @PathVariable int id){
        if(team.getId() == id)
            teamServices.updateTeam(team);
    }

    @DeleteMapping("/{id}")
    public void deleteTeam (@PathVariable int id){
        teamServices.deleteTeam(id);
    }

}
