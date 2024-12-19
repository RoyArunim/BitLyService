package org.example.controller;

import org.example.model.Url;
import org.example.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api")
public class UrlController {
    @Autowired
    UrlService urlService;

    @PostMapping("/createShortUrl")
    public ResponseEntity<Url> createShortUrl(@RequestBody Url url){
        Url shortUrl = urlService.createShortUrl(url.getOriginalUrl(), url.getUserId(), url.getExpiryDate());
        return ResponseEntity.ok(shortUrl);
    }

    @GetMapping("")

}
