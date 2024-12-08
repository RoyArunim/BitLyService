package org.example.repositories;

import org.example.model.UrlUsageStats;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UrlUsageStatsRepository extends JpaRepository<UrlUsageStats, Long> {
    Optional<UrlUsageStats> findByUrlID(Long urlId);
}
