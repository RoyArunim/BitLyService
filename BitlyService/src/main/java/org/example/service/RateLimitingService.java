package org.example.service;

import org.example.model.UserEntity;
import org.example.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class RateLimitingService {

    @Autowired
    UserRepository userRepository;

    public boolean allowUser(Long userId) throws Exception {
        UserEntity user = userRepository.findById(userId).orElseThrow(()-> new Exception("User not found"));
        if(LocalDateTime.now().isAfter(user.getRateLimitTimeReset())){
            user.setRateLimitTimeReset(LocalDateTime.now().plusMinutes(1));
            user.setCountOfRequests(0);
        }

        if(user.getCountOfRequests()>10){
            return false;
        }

        user.setCountOfRequests(user.getCountOfRequests()+1);
        userRepository.save(user);
        return true;

    }
}
