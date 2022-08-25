package com.acheron.offlinecommunication.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Auditor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer auditorId;
    private String auditorName;




//    @JsonIgnore
//    @OneToOne(mappedBy = "auditor")
//    private Request request;



}
