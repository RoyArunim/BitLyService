package org.example.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Url {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String shortUrl;
    @Column(nullable = false)
    private String originalUrl;
    private LocalDateTime expiryDate;
    private Long userId;//for rate limiting

    public Url(Builder builder){
        this.id=builder.id;
        this.originalUrl=builder.originalUrl;
        this.shortUrl=builder.shortUrl;
        this.expiryDate=builder.expiryDate;
        this.userId=builder.userId;
    }

    public static class Builder{
         private Long id;
         private String shortUrl;
         private String originalUrl;
         private LocalDateTime expiryDate;
         private Long userId;
         public static Builder newInstance(){
             return new Builder();
         }

         private Builder(){}

        public Builder setId(Long id){
             this.id=id;
             return this;
        }

        public Builder setShortUrl(String shortUrl){
             this.shortUrl=shortUrl;
             return this;
        }

        public Builder setExpiryDate(LocalDateTime expiryDate){
             this.expiryDate=expiryDate;
             return this;
        }

        public Builder setOriginalUrl(String originalUrl){
             this.originalUrl=originalUrl;
             return this;
        }

        public Builder setUserId(Long userId){
             this.userId=userId;
             return this;
        }

        public Url build(){
             return new Url(this);
        }
    }

}
