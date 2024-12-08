package org.example.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
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

}
