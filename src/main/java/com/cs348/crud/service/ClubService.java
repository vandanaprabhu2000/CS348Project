package com.cs348.crud.service;

import com.cs348.crud.entities.Club;
import com.cs348.crud.repositories.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClubService {
    @Autowired
    private ClubRepository clubRepository;
    public void addtoClubs(Club s) throws Exception{
        clubRepository.save(s);
    }
    public List<Club> getClubs(){
        return clubRepository.findAll();
    }
    public Optional<Club> getClubById(Integer id){
        return clubRepository.findById(id);
    }
    public void deleteClub(Integer id){
        clubRepository.deleteById(id);
    }
    public void deleteClub(Club s){
        clubRepository.deleteById(s.getId());
    }
     public void setClubRepository(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }
}
