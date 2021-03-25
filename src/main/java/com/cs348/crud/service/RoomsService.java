package com.cs348.crud.service;
import com.cs348.crud.repositories.RoomsRepository;
import com.cs348.crud.entities.Rooms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class RoomsService {
    @Autowired
    private RoomsRepository roomsRepository;
    public void addtoRooms(Rooms s) throws Exception {
        roomsRepository.save(s);
    }
    public List<Rooms> getRooms(){
        return roomsRepository.findAll();
    }
    public Optional<Rooms> getRoomsById(Integer id){
        return roomsRepository.findById(id);
    }
    public void deleteRooms(Integer id){
        roomsRepository.deleteById(id);
    }
    public void deleteRooms(Rooms s){
        roomsRepository.deleteById(s.getId());
    }
     public void setRoomsRepository(RoomsRepository roomsRepository) {
        this.roomsRepository = roomsRepository;
    }
}
