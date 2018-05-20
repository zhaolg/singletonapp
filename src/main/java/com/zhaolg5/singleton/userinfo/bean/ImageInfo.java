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
public class ImageInfo {

    @Id
    @GeneratedValue
    @Column(length = 14)
    private long imageId;

    /**
     * 关联的用户编号
     */
    @Column(length = 14)
    private long userId;

    /**
     * 用于图片展示过程中的排序
     */
    @Column(length = 14)
    private long sortId;

    public long getSortId() {
        return sortId;
    }

    public void setSortId(long sortId) {
        this.sortId = sortId;
    }

    /**
     * 图片的绝对路径
     */
    @Column(nullable = true,length = 1024)
    private String imageUrl;

    /**
     * 图片的类型
     */
    @Column(nullable = true,length = 1024)
    private String imageType;

    /**
     * 数据状态：U有效 E生效
     */
    @Column(nullable = true,length = 1)
    private String state = "U";

    /**
     * 创建时间
     */
    private Date createDate = new Date();

    /**
     * 生效时间
     */
    private Date effDate = new Date();
    /**
     *失效时间，默认为2099年12月31日
     */
    private Date expDate = DateUtils.get20991231();
    /**
     *失效时间，默认为2099年12月31日
     */
    private String remark;
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

    public long getImageId() {
        return imageId;
    }

    public void setImageId(long imageId) {
        this.imageId = imageId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
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
