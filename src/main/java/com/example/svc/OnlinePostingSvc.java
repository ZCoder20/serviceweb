package com.example.svc;

import com.example.repo.OnlinePostingRepo;
import com.example.repo.domain.InlineRespone201;
import com.example.repo.domain.OnlinePosting;
import jakarta.persistence.criteria.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
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

    public List<OnlinePosting> findByparameter(String category,String postTitle,
                                               int totalF1, int totalF2, int totalF3, int price) {
      /*  return onlinePostingRepo.findByCategoryAndPostTitleAndTotalF1AndTotalF2AndTotalF3AndPrice(category,postTitle,totalF1,
                totalF2,totalF3,price);*/
        return  null;
    }

    public List<OnlinePosting> findAlllaterst() {
        return onlinePostingRepo.findAllByOrderByPostIdDesc();
    }
    public List<OnlinePosting> findByCategory(String category) {
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
    public List<OnlinePosting> findOnlinePostingByCategoryAndAndPriceAndTotalF1(String category,double price,
                                                                                double totalF1 ) {
        return onlinePostingRepo.findOnlinePostingByCategoryAndAndPriceAndTotalF1(category,price,totalF1);
    }

    public List<OnlinePosting> findAll(String category, double price, double totalF1, String plat,String pstlang)
    {

        Specification searchEmployees =  searchEmployees(category,price,totalF1,plat,pstlang);
        return onlinePostingRepo.findAll(searchEmployees);

    }


        public  Specification<OnlinePosting> searchEmployees(String category, double price, double totalF1, String plat,String pstlang) {
            return (root, query, cb) -> {
                List<Predicate> predicates = new ArrayList<>();

                if (category != null && !category.isEmpty()) {
                    predicates.add(cb.equal(root.get("category"), category));
                }

                if (price != 0.0) {
                    predicates.add(cb.equal(root.get("price"), price));
                }

                if (totalF1 != 0.0) {
                    predicates.add(cb.equal(root.get("totalF1"), totalF1));
                }



                if (plat != null && !plat.isEmpty()) {
                    predicates.add(cb.equal(root.get("plat"), plat));
                }

                if (pstlang != null && !pstlang.isEmpty()) {
                    predicates.add(cb.equal(root.get("pstlang"), pstlang));
                }



                return cb.and(predicates.toArray(new Predicate[0]));
            };
        }


}
