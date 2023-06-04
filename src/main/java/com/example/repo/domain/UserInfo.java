package com.example.repo.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name="userinfo")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class UserInfo {
    @Id
    @Column(name = "userid", unique=true, nullable = false)
    private int userId;
    @Transient
    private String imagePath;
    @Column(name="firstname", nullable = false)
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "middlename")
    private String middleName;
    @Column(name = "dob")
    private Date dob;
    @Column(name = "streetaddress1")
    private String streetAddress1;
    @Column(name = "streetaddress2")
    private String streetAddress2;
    @Column(name = "city")
    private String city;
    @Column(name = "state")
    private String state;
    @Column(name = "country")
    private String country;
    @Column(name = "idnumber")
    private int idNumber;
    @Column(name = "idtype")
    private String idType;
    @Column(name = "issuecountry")
    private String issueCountry;
    @Column(name = "citizencountry")
    private String citizenCountry;
    @Column(name = "photoid") // optional
    private byte[] photoID;
    @Column(name = "taxdoc")   // optional
    private byte[] taxDoc;
    @Column(name = "categorypreference")
    private String categoryPreference;
    @Column(name = "iscompany")
    private boolean isCompany;
    @Column(name = "isseller")
    private boolean isSeller;
    @Column(name = "email")
    private String emailId;
    @Column(name = "phonenum1")
    private int phoneNum1;
    @Column(name = "phonenum2")  // optional
    private int phoneNum2;

    @Column(name = "businessemail")   // optional
    private String businessEmail;
    @Column(name = "countryofbus")
    private String countryOfBusiness;
    @Column(name = "verificationlink")
    private String verificationLink;

}
