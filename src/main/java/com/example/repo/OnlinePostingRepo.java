package com.example.repo;


import com.example.repo.domain.OnlinePosting;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OnlinePostingRepo extends org.springframework.data.repository.Repository<OnlinePosting,Long> {

    OnlinePosting save(OnlinePosting onlinePosting);
    List<OnlinePosting> findAll();
    List<OnlinePosting> findByCategoryAndPostTitleAndTotalF1AndTotalF2AndTotalF3AndPrice(int category,String posttitle,
                                                                                                      int totalF1, int totalF2,
                                                                                                      int totalF3,int price);
    List<OnlinePosting> findByCategory(int category);


    List<OnlinePosting> findByPrice(int price);

    List<OnlinePosting> findByPostTitle(String title);

    List<OnlinePosting> findByUserId(int userId);
}
