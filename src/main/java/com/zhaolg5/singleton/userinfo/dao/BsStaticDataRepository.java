package com.zhaolg5.singleton.userinfo.dao;

import com.zhaolg5.singleton.userinfo.bean.BsStaticData;
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
public interface BsStaticDataRepository extends JpaRepository<BsStaticData,String> {

    @Query("select p from BsStaticData p where p.codeType =:codeType and p.state = 'U' ")
    List<BsStaticData> findAllByCodeType(@Param("codeType") String codeType);

}
