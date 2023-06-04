package com.example.repo.domain;

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
    @Column(name = "posttitle", nullable = true)
    private String postTitle;
    @Column(name = "posturl", nullable = true)
    private String postURL;
    @Column(name = "postdetails", nullable = true)
    private String postDetails;
    @Column(name = "total_v", nullable = true)
    private int totalF1;
    @Column(name = "total_s", nullable = true)
    private int totalF2;
    @Column(name = "total_l", nullable = true)
    private int totalF3;
    @Column(name = "total_p", nullable = true)
    private int totalF4;
    @Column(name = "category", nullable = true)
    private String category;
    @Column(name = "price", nullable = true)
    private double price;

    @Column(name = "userid", nullable = true)
    private int userId;

    @Column(name = "plat", nullable = true)
    private String plat;
    @Column(name = "smname", nullable = true)
    private String smname;
    @Column(name = "rsn_rest", nullable = true)
    private String rsn_rest;
    @Column(name = "imgpath", nullable = true)
    private String imgpath;

    @Column(name = "smage", nullable = true)
    private int smage;

    @Column(name = "monot", nullable = true)
    private boolean monot;
    @Column(name = "isrestric", nullable = true)
    private boolean isrestric;
    @Column(name = "isactive", nullable = true)
    private boolean isactive;
    @Column(name = "pstlang", nullable = true)
    private String pstlang;
}








