package com.example.postgres.svc;

import com.example.postgres.repo.OnlinePostingRepo;
import com.example.postgres.repo.domain.InlineRespone201;
import com.example.postgres.repo.domain.OnlinePosting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Console;
import java.util.List;

@Component
public class OnlinePostingSvc {
    private final OnlinePostingRepo onlinePostingRepo;
    @Autowired
    public OnlinePostingSvc(OnlinePostingRepo onlinePostingRepo){
        this.onlinePostingRepo = onlinePostingRepo;
    }
    public InlineRespone201 savePosting(OnlinePosting onlinePosting) {


       OnlinePosting posting = onlinePostingRepo.save(onlinePosting);
        return new InlineRespone201().postingIdentifier(posting.getPostId());
    }

    public List<OnlinePosting> findByparameter(int category,String postTitle,
                                               int totalF1, int totalF2, int totalF3, int price) {
        return onlinePostingRepo.findByCategoryAndPostTitleAndTotalF1AndTotalF2AndTotalF3AndPrice(category,postTitle,totalF1,
                totalF2,totalF3,price);
    }

    public List<OnlinePosting> findAll() {
        return onlinePostingRepo.findAll();
    }
    public List<OnlinePosting> findByCategory(int category) {
        System.out.println(category);
        return onlinePostingRepo.findByCategory(category);
    }

    public List<OnlinePosting> findByPrice(int price) {
        System.out.println(price);
        return onlinePostingRepo.findByPrice(price);
    }

    public List<OnlinePosting> findByTitle(String title) {
        System.out.println(title);
        return onlinePostingRepo.findByPostTitle(title);
    }


}
