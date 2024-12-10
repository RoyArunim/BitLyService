package org.example.service;

import org.example.model.Url;
import org.example.model.UrlUsageStats;
import org.example.repositories.UrlUsageStatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UrlUsageStatsService {
@Autowired
    UrlUsageStatsRepository urlUsageStatsRepository;

    public void UsageLogs(Url url, String browser, String location){
        UrlUsageStats stats = new UrlUsageStats();
        stats.setUrl(url);
        stats.setBrowser(browser);
        stats.setLocation(location);
        stats.setLocalDate(LocalDateTime.now());
        urlUsageStatsRepository.save(stats);
    }
}
