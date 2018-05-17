package com.zhaolg5.singleton.userinfo.dao;

import com.zhaolg5.singleton.userinfo.bean.ImageInfo;
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
public interface ImageInfoRepository extends JpaRepository<ImageInfo, Long> {


    @Query("select p from ImageInfo p where p.userId =:userId ")
    List<ImageInfo> findOneByUserId(@Param("userId") long userId);

}
