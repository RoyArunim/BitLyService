package org.example.service;

import org.example.model.Url;
import org.example.repositories.UrlRepository;
import org.example.repositories.UrlUsageStatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class UrlService {

    @Autowired
    UrlRepository urlRepository;

    @Autowired
    UrlUsageStatsRepository urlStatsRepository;

    public Url createShortUrl(String originalUrl, Long userId, LocalDateTime expiryDate){
        String shortUrl = generateShortUrl();
        Url url = Url.Builder.newInstance()
                        .setOriginalUrl(originalUrl)
                        .setShortUrl(shortUrl)
                        .setExpiryDate(expiryDate)
                        .setUserId(userId)
                        .build();

        return urlRepository.save(url);

    }

    public String getOriginalUrl(String shortUrl){

    }

    public String generateShortUrl(){

    }

}
