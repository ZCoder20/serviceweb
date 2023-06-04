package com.example.svc;
import com.example.repo.OrderRepo;
import com.example.repo.domain.InlineRespone201;
import com.example.repo.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderSvc {

    private final OrderRepo orderrepo;

    @Autowired
    public OrderSvc(OrderRepo orderrepo){
        this.orderrepo = orderrepo;
    }

    public InlineRespone201 saveorder( int userId,  int postId,  int totalhr,  int totslprice, String odrUrl, String odrdetails,
                                      String odrtitle,String odrstatus,String concent,boolean istermaccepted)  {


        // Create a new person entity with the details

        Order orderinfo = Order.builder().userid(userId).postid(postId).totalhr(totalhr).totalprice(totslprice).
                odrurl(odrUrl).orddetails(odrdetails).ordtitle(odrtitle).
                odrstatus(odrstatus).concent(concent).
                trmsaccepted(istermaccepted).build();

        Order orderobj = orderrepo.save(orderinfo);
        return new InlineRespone201().postingIdentifier(orderobj.getOdrid());

    }

    public List<Order> findByUserid(int orderid) {

        return orderrepo.findByUserid(orderid);
    }
}
