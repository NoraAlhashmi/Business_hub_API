package com.example.Falak.services;

import com.example.Falak.model.Team;
import com.example.Falak.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;





























@Service
public class TeamServices {


    @Autowired
    private TeamRepository teamRepository;


    public List<Team> getAllTeams (){
        List<Team> teamList = new ArrayList<>();
        teamRepository.findAll().forEach(teamList::add);
        return teamList;
    }

    public Team getTeam(int id){
        return teamRepository.findById(id).orElse(null);
    }

    public void addTeam(Team team){
        teamRepository.save(team);
    }

    public void updateTeam(Team team){
        teamRepository.save(team);
    }

    public void deleteTeam(int id){
        teamRepository.deleteById(id);
    }

}
