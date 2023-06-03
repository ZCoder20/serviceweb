package com.example.postgres.repo.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "onlineposting")
@Setter
@Getter
public class OnlinePosting {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "postid")
    private int postId;
    @Column(name = "posttitle", nullable = false)
    private String postTitle;
    @Column(name = "posturl", nullable = false)
    private String postURL;
    @Column(name = "postdetails", nullable = false)
    private String postDetails;
    @Column(name = "total_v", nullable = false)
    private int totalF1;
    @Column(name = "total_s", nullable = false)
    private int totalF2;
    @Column(name = "total_l", nullable = false)
    private int totalF3;
    @Column(name = "total_p", nullable = false)
    private int totalF4;
    @Column(name = "category", nullable = false)
    private int category;
    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "userid", nullable = false)
    private int userId;

    @Column(name = "plat", nullable = false)
    private String plat;
    @Column(name = "smname", nullable = false)
    private String smname;
    @Column(name = "rsn_rest", nullable = true)
    private String rsn_rest;
    @Column(name = "imgpath", nullable = false)
    private String imgpath;

    @Column(name = "smage", nullable = false)
    private int smage;

    @Column(name = "monot", nullable = true)
    private boolean monot;
    @Column(name = "isrestric", nullable = true)
    private boolean isrestric;
    @Column(name = "isactive", nullable = false)
    private boolean isactive;
}








