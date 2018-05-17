package com.zhaolg5.singleton.userinfo.dao;

import com.zhaolg5.singleton.userinfo.bean.UserTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by zhaolg on 2018/5/17
 *
 * @return
 * @throws Exception
 */
public interface UsertagRepository extends JpaRepository<UserTag,String> {


    @Query("select p from UserTag p where p.userId =:userId ")
    List<UserTag> findOneByUserId(@Param("userId") long userId);


}
