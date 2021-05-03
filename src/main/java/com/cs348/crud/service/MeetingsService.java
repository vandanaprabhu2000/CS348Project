package com.cs348.crud.service;

import com.cs348.crud.entities.Meetings;
import com.cs348.crud.repositories.MeetingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class MeetingsService {
    @Autowired
    private MeetingsRepository meetingsRepository;
    public void addtoMeetings(Meetings s) throws Exception {
        meetingsRepository.save(s);
    }
    public List<Meetings> getMeetings(){
        return meetingsRepository.findAll();
    }
    public Optional<Meetings> getMeetingsById(Integer id){
        return meetingsRepository.findById(id);
    }
    public void deleteMeetings(Integer id){
        meetingsRepository.deleteById(id);
    }
    public void deleteMeetings(Meetings s){
        meetingsRepository.deleteById(s.getMeeting_id());
    }
    public void setMeetingsRepository(MeetingsRepository meetingsRepository) {
        this.meetingsRepository = meetingsRepository;
    }
}
