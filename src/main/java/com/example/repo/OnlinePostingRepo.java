package com.example.repo;


import com.example.repo.domain.OnlinePosting;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;



@Repository
public interface OnlinePostingRepo extends org.springframework.data.repository.Repository<OnlinePosting,Long> {

    OnlinePosting save(OnlinePosting onlinePosting);
    List<OnlinePosting> findAllByOrderByPostIdDesc();
    /*List<OnlinePosting> findByCategoryAndPostTitleAndTotalF1AndTotalF2AndTotalF3AndPrice(String category,String posttitle,
                                                                                                      int totalF1, int totalF2,
                                                                                                      int totalF3,int price);

   */
    //List<OnlinePosting> findByCategory(String category);
    List<OnlinePosting> findByCategory(String category);

    List<OnlinePosting> findByPrice(double price);

    List<OnlinePosting> findByPostTitle(String title);


    List<OnlinePosting> findOnlinePostingByCategoryAndAndPriceAndTotalF1(String category,double price, double totalF1);

    List<OnlinePosting> findAll(Specification searchEmployees);

 //   List<OnlinePosting> findOnlinePostingByCategoryAndAndPriceAndTotalF1AAndPlat(String category,double price, double totalF1,String plat);


}
