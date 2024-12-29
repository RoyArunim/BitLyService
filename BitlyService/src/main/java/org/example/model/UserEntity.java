package org.example.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    private int countOfRequests;
    private LocalDateTime rateLimitTimeReset;

    public Long getId(){
        return id;
    }

    public String getUsername(){
        return username;
    }

    public int getCountOfRequests(){
        return countOfRequests;
    }

    public LocalDateTime getRateLimitTimeReset(){
        return rateLimitTimeReset;
    }

    public void setId(Long id){
        this.id=id;
    }

    public void setUsername(String username){
        this.username=username;
    }

    public void setCountOfRequests(int countOfRequests){
        this.countOfRequests=countOfRequests;
    }

    public void setRateLimitTimeReset(LocalDateTime rateLimitTimeReset){
        this.rateLimitTimeReset=rateLimitTimeReset;
    }
}
