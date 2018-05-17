package com.zhaolg5.singleton.userinfo.dao;

import com.zhaolg5.singleton.userinfo.bean.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by zhaolg on 2018/1/21
 *
 * @return
 * @throws Exception
 */
public interface UserinfoRepository extends JpaRepository<UserInfo, Long> {

    @Query("select p from UserInfo p where p.userId =:userId ")
     UserInfo findOneByUserId(@Param("userId") long userId);

}
