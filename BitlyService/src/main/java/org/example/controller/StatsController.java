package org.example.controller;

import org.example.model.Url;
import org.example.model.UrlUsageStats;
import org.example.repositories.UrlRepository;
import org.example.repositories.UrlUsageStatsRepository;
import org.example.service.UrlService;
import org.example.service.UrlUsageStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StatsController {

    @Autowired
    UrlService urlService;

    @Autowired
    UrlUsageStatsService statsService;

    @GetMapping("/getStats/{shortUrl}")
    public ResponseEntity<UrlUsageStats> getStats(@PathVariable String shortUrl) throws Exception {

        Long urlId = urlService.getOriginalUrl(shortUrl).getId();
        UrlUsageStats stats = statsService.getStats(urlId);
        return ResponseEntity.ok(stats);
    }
}
