package org.example.model;

import jakarta.persistence.*;

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

}
