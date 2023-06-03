package com.example.postgres.repo;

import com.example.postgres.repo.domain.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends org.springframework.data.repository.Repository<Order,Long> {

   Order save(Order order);
   //List<Order> findByOdrid(int odrid);
   List<Order> findByUserid(int userid);
  // List<Order> findByOrderByUserid(int userid);


   List<Order> findByUseridAndPostid(int userid,int postid);

}
