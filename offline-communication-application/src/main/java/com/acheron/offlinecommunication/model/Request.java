package com.acheron.offlinecommunication.model;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer requestId;
    private String seriesName;
    private int episodeNumber;
    private int seriesReleaseYear;
    private double rating;
    private String episodeDescription;
    private String genre;
    private String language;
    private String directorName;
    private String producerName;
    private String status;

    private String createdBy;
    private LocalDateTime createdAt;
    private String updatedBy;
    private LocalDateTime updatedAt;
    private boolean isDeleted;


    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "auditorId")
    private Auditor auditor;

    @ManyToMany()
    @JoinTable(name ="request_actor", joinColumns = {@JoinColumn(name="request_id")} , inverseJoinColumns = @JoinColumn(name="actor_id"))
    private List<Actor> actors;


}
