package com.example.repo.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "odrdata")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "odrid")
    private int odrid;

    @Column(name = "postid", nullable = false)
    private int postid;
    @Column(name = "userid", nullable = false)
    private int userid;
    @Column(name = "totalhr", nullable = false)
    private int totalhr;
    @Column(name = "totalprice", nullable = false)
    private int totalprice;


    @Column(name = "odrurl", nullable = false)
    private String odrurl;
    @Column(name = "orddetails", nullable = false)
    private String orddetails;
    @Column(name = "ordtitle", nullable = true)
    private String ordtitle;
    @Column(name = "odrstatus", nullable = false)
    private String odrstatus;



    @Column(name = "trmsaccepted", nullable = true)
    private boolean trmsaccepted;

    @Column(name = "concent", nullable = true)
    private String concent;



}








