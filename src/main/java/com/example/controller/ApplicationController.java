package com.example.controller;

import com.example.common.util.FileDownloadUtil;
import com.example.repo.domain.InlineRespone201;
import com.example.repo.domain.OnlinePosting;
import com.example.repo.domain.Order;
import com.example.repo.domain.UserInfo;
import com.example.svc.OnlinePostingSvc;
import com.example.svc.OrderSvc;
import com.example.svc.UserInfoSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:63342")
@RequestMapping("/vi/api")
public class ApplicationController {
    private final UserInfoSvc userInfoSvc;
    private final OnlinePostingSvc onlinePostingSvc;

    private final OrderSvc ordersvc;


    @Autowired
    public ApplicationController(UserInfoSvc userInfoSvc, OnlinePostingSvc onlinePostingSvc, OrderSvc ordersvc) {
        this.userInfoSvc = userInfoSvc;
        this.onlinePostingSvc = onlinePostingSvc;
        this.ordersvc = ordersvc;

    }



    @GetMapping("{getImage}")
    public ResponseEntity<?> downloadFile(@PathVariable("getImage") String fileCode) {
        FileDownloadUtil downloadUtil = new FileDownloadUtil();

        Resource resource = null;
        try {
            resource = downloadUtil.getFileAsResource(fileCode);
        } catch (IOException e) {
            return ResponseEntity.internalServerError().build();
        }

        if (resource == null) {
            return new ResponseEntity<>("File not found", HttpStatus.NOT_FOUND);
        }

        String contentType = "application/octet-stream";
        String headerValue = "attachment; filename=\"" + resource.getFilename() + "\"";

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, headerValue)
                .body(resource);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/userRegistration")
    public ResponseEntity<String> registerUser(@RequestParam int userId,
                                               @RequestParam String isSeller,
                                               @RequestParam String isCompany,
                                               @RequestParam String firstName,
                                               @RequestParam String middleName,
                                               @RequestParam String lastName,
                                               @RequestParam String dob,
                                               @RequestParam String streetAddress1,
                                               @RequestParam String city,
                                               @RequestParam String state,
                                               @RequestParam String country,
                                               @RequestParam String citizenCountry,
                                               @RequestParam int idNumber,
                                               @RequestParam String idType,
                                               @RequestParam String issueCountry,
                                               @RequestParam String categoryPreference,
                                               @RequestParam String emailId,
                                               @RequestParam int phoneNum1,
                                               @RequestParam String countryOfBusiness,
                                               @RequestParam String verificationLink,
                                               @RequestParam("imageFile") MultipartFile imageFile) throws IOException {


        InlineRespone201 response = userInfoSvc.saveUserInfo(userId, isSeller, isCompany,
                firstName, middleName, lastName, dob,
                streetAddress1, city, state, country, idNumber, idType, issueCountry, citizenCountry,
                categoryPreference, emailId, phoneNum1, countryOfBusiness, verificationLink, imageFile);
        return ResponseEntity.ok("User resgistered");
    }
    // to get user by the id
    @GetMapping(path="/getUserById",produces =MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<UserInfo> byUserId(@RequestParam int userId){
        System.out.println("byUserId");

       // System.out.println(userInfoSvc.byUserId(userId));

        return  ResponseEntity.ok().body(userInfoSvc.byUserId(userId));
    }


    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/onlinePosting")
    public HttpEntity<HttpStatus> postOnlineContent(@RequestBody OnlinePosting onlinePosting) {
        System.out.println("Posting");
        InlineRespone201 response = onlinePostingSvc.savePosting(onlinePosting);
        return new HttpEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping(path = "/specificPosting")
    public List<OnlinePosting> specificPosting(@RequestParam int category, @RequestParam String postTitle,
                                               @RequestParam int totalF1, @RequestParam int totalF2,
                                               @RequestParam int totalF3, @RequestParam int price) {
        List<OnlinePosting> posts = onlinePostingSvc.findByparameter(category, postTitle, totalF1, totalF2, totalF3, price);

        return posts;
    }

    @GetMapping(path = "/allPosting")
    public List<OnlinePosting> allPosting() {
        List<OnlinePosting> posts = onlinePostingSvc.findAll();

        return posts;
    }
    @GetMapping(path = "/postingByUserId")
    public List<OnlinePosting> postingByUserId(@RequestParam int userId) {
        System.out.println(userId);
        List<OnlinePosting> posts = onlinePostingSvc.findByUserId(userId);

        return posts;
    }
    @GetMapping(path = "/byCategory")
    public List<OnlinePosting> postingByCategory(@RequestParam int category) {
        List<OnlinePosting> posts = onlinePostingSvc.findByCategory(category);

        return posts;
    }

    @GetMapping(path = "/byPrice")
    public List<OnlinePosting> postingByPrice(@RequestParam int price) {
        List<OnlinePosting> posts = onlinePostingSvc.findByPrice(price);

        return posts;
    }

    @GetMapping(path = "/byTitle")
    public List<OnlinePosting> postingByTitle(@RequestParam String posttitle) {

        List<OnlinePosting> posts = onlinePostingSvc.findByTitle(posttitle);

        return posts;
    }

    // Order save
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/ordersave")
    public ResponseEntity<String> saveorder(@RequestParam int userId,
                                            @RequestParam int postId,
                                            @RequestParam int totalhr,
                                            @RequestParam int totslprice,
                                            @RequestParam String odrUrl,
                                            @RequestParam String odrdetails,
                                            @RequestParam String odrtitle,
                                            @RequestParam String odrstatus,
                                            @RequestParam String concent,
                                            @RequestParam boolean istermaccepted) {
        //   System.out.println("Registration   "+userinfo.getPhotoID());

        InlineRespone201 response = ordersvc.saveorder(userId, postId, totalhr, totslprice,
                odrUrl, odrdetails, odrtitle, odrstatus, concent, istermaccepted);
        return ResponseEntity.ok("order detials saved successfully");
    }

    @GetMapping(path = "/getorder")
    public List<Order> detailsByorder(@RequestParam int orderid) {

        List<Order> order = ordersvc.findByUserid(orderid);

        return order;
    }

    @GetMapping(path="/oderByPostId" )
    public HttpEntity<Order> byOderByPostId(@RequestParam int postId){
        System.out.println("OderByPostId");
        System.out.println(ordersvc.oderByPostId(postId));
        ResponseEntity.ok().body( ordersvc.oderByPostId(postId));
        return ResponseEntity.ok().body( ordersvc.oderByPostId(postId));
    }

}




