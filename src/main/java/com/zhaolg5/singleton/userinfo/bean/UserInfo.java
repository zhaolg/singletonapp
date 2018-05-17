package com.zhaolg5.singleton.userinfo.bean;

import com.zhaolg5.singleton.userinfo.utils.DateUtils;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by zhaolg on 2018/5/16
 *
 * @return
 * @throws Exception
 */
@Entity
@Table(name = "USER_INFO")
public class UserInfo {

    @Id
    @GeneratedValue
    @Column(length = 14)
    private long userId;

    /**
     * 用户名称
     */
    @Column(length = 255 )
    private String userName;

    /**
     * 年龄 0代表其他 1代表男 2代表女
     */
    @Column(length = 2)
    private Integer gender;

    /**
     * 出身日期
     */
    private Date birthday;

    /**
     * 当前所在省份
     */
    @Column(length = 100)
    private String currProvince;

    /**
     * 当前所在市
     */
    @Column(length = 100)
    private String currCity;
    /**
     * 籍贯所在省份
     */
    @Column(length = 100)
    private String nativeProvince;
    /**
     * 籍贯所在市
     */
    @Column(length = 100)
    private String nativeCity;
    /**
     * 所在国家
     */
    @Column(length = 100)
    private String country;
    /**
     * 大学名称
     */
    private String college;
    /**
     * 学历
     */
    private String edu;
    /**
     * 自我介绍
     */
    @Column(length = 2048)
    private String selfIntroduction;
    /**
     * 用户状态：U有效 E生效
     */
    @Column(length = 2 )
    private String state;
    /**
     * 创建时间，即用户第一次进行登录的时间
     */
    private Date createDate = new Date();
    /**
     * 生效时间，即用户第一次进行登录的时间
     */
    private Date effDate = new Date();
    /**
     * 失效时间，默认为2099年12月31日
     */
    private Date expDate = DateUtils.get20991231();
    /**
     * 备注信息
     */
    private String remark;

    public long getUserId() {
        return userId;
    }

    public String getSelfIntroduction() {
        return selfIntroduction;
    }

    public void setSelfIntroduction(String selfIntroduction) {
        this.selfIntroduction = selfIntroduction;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getEffDate() {
        return effDate;
    }

    public void setEffDate(Date effDate) {
        this.effDate = effDate;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getCurrProvince() {
        return currProvince;
    }

    public void setCurrProvince(String currProvince) {
        this.currProvince = currProvince;
    }

    public String getCurrCity() {
        return currCity;
    }

    public void setCurrCity(String currCity) {
        this.currCity = currCity;
    }

    public String getNativeProvince() {
        return nativeProvince;
    }

    public void setNativeProvince(String nativeProvince) {
        this.nativeProvince = nativeProvince;
    }

    public String getNativeCity() {
        return nativeCity;
    }

    public void setNativeCity(String nativeCity) {
        this.nativeCity = nativeCity;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getEdu() {
        return edu;
    }

    public void setEdu(String edu) {
        this.edu = edu;
    }

}
