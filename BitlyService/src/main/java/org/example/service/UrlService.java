package org.example.service;

import org.aspectj.bridge.Message;
import org.example.model.Url;
import org.example.repositories.UrlRepository;
import org.example.repositories.UrlUsageStatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;

import java.time.LocalDateTime;
import java.util.Optional;

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

    public String getOriginalUrl(String shortUrl) throws Exception {
        Url url = urlRepository.findByShortUrl(shortUrl).orElseThrow(() -> new Exception("Short URL not found"));;
        if(url.getExpiryDate()!=null || url.getExpiryDate().isAfter(LocalDateTime.now())){
            throw new Exception("Url is expired");
        }

        return url.getOriginalUrl();


    }

    public String generateShortUrl(String longUrl){

        try{
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(longUrl.getBytes());
            byte[] digest = messageDigest.digest();


            //convert byte array to sign representation
            BigInteger no = new BigInteger(1,digest);
            //Convert message digest to hexadecimal value
            String hashText = no.toString(16);
            while (hashText.length() < 32) {
                hashText = "0" + hashText;
            }

            // Return a shorter substring for URL shortening purposes (e.g., first 8 characters)
            return hashText.substring(0, 8);

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 algorithm not found");
        }
    }

}
