package org.example.controller;

import org.example.Dtos.UrlDto;
import org.example.model.Url;
import org.example.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class UrlController {
    @Autowired
    UrlService urlService;

    @PostMapping("/createShortUrl")
    public ResponseEntity<UrlDto> createShortUrl(@RequestBody Url url){
        Url shortUrl = urlService.createShortUrl(url.getOriginalUrl(), url.getUserId(), url.getExpiryDate());
        UrlDto urlDtoMappedUrl = urlMapper(shortUrl);
        return ResponseEntity.ok(urlDtoMappedUrl);
    }

    UrlDto urlMapper(Url shortUrl){
        UrlDto urlDto=new UrlDto();
        urlDto.shortUrl = shortUrl.getShortUrl();
        return urlDto;
    }

    @GetMapping("/getOriginal/{shortUrl}")
    public ResponseEntity<Url> getOriginalUrl(@PathVariable String shortUrl) throws Exception {
        Url originalUrl =  urlService.getOriginalUrl(shortUrl);
        return ResponseEntity.ok(originalUrl);
    }



}
