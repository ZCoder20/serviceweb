package com.example.repo;

import com.example.repo.domain.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserInfoRepo extends org.springframework.data.repository.Repository<UserInfo,Long> {

    UserInfo save(UserInfo userInfo);
    List<UserInfo> findAll();
    UserInfo getAllByUserId(int userId);


    UserInfo findUserInfoByUserId(Integer userId);
  //  UserInfo getUserInfoByUserId(Integer userId);

  //  UserInfo getByUserId(Integer userId);

}
