package com.example.svc;
import com.example.common.util.ByteUtil;
import com.example.repo.OrderRepo;
import com.example.repo.UserInfoRepo;
import com.example.repo.domain.InlineRespone201;
import com.example.repo.domain.OnlinePosting;
import com.example.repo.domain.Order;
import com.example.repo.domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.file.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;
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

    public Order oderByPostId(int postId) {

        return orderrepo.findByPostid(postId);
    }
}
