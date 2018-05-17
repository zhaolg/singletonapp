package com.zhaolg5.singleton.userinfo.bean;

import com.zhaolg5.singleton.userinfo.utils.DateUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by zhaolg on 2018/5/16
 *
 * @return
 * @throws Exception
 */
@Entity
public class UserTag {

    @Id
    @GeneratedValue
    @Column(length = 14)
    private long tagId;

    /**
     * 关联的用户编号
     */
    @Column(nullable = true,length = 14)
    private long userId;
    /**
     * 用户标签名称
     */
    private String tagName;

    /**
     * 用户标签类型
     */
    private String tagType;
    /**
     *用户标签扩展字段a
     */
    private String extA;
    /**
     *用户标签扩展字段b
     */
    private String extB;
    /**
     *用户标签扩展字段c
     */
    private String extC;
    /**
     *数据状态：U有效 E生效
     */
    @Column(nullable = true,length = 1)
    private String state;
    /**
     *创建时间
     */
    private Date createDate = new Date();
    /**
     *生效时间
     */
    private Date effDate = new Date();
    /**
     *失效时间，默认为2099年12月31日
     */
    private Date expDate = DateUtils.get20991231();
    /**
     * 备注信息
     */
    private String remark;

    public long getTagId() {
        return tagId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setTagId(long tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getTagType() {
        return tagType;
    }

    public void setTagType(String tagType) {
        this.tagType = tagType;
    }

    public String getExtA() {
        return extA;
    }

    public void setExtA(String extA) {
        this.extA = extA;
    }

    public String getExtB() {
        return extB;
    }

    public void setExtB(String extB) {
        this.extB = extB;
    }

    public String getExtC() {
        return extC;
    }

    public void setExtC(String extC) {
        this.extC = extC;
    }
}
