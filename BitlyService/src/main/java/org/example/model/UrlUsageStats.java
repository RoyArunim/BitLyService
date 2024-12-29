package org.example.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
public class UrlUsageStats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "url_id")
    private Url url;

    private LocalDateTime localDate;
    private String browser;
    private String location;

    public Long getId(){
        return id;
    }

    public Url getUrl(){
        return url;
    }

    public LocalDateTime getLocalDate(){
        return localDate;
    }

    public String getBrowser(){
        return browser;
    }

    public String getLocation(){
        return location;
    }

    public void setId(Long id){
        this.id=id;
    }

    public void setUrl(Url url){
        this.url=url;
    }

    public void setLocalDate(LocalDateTime localDate){
        this.localDate=localDate;
    }

    public void setBrowser(String browser){
        this.browser=browser;
    }

    public void setLocation(String location){
        this.location=location;
    }



}
