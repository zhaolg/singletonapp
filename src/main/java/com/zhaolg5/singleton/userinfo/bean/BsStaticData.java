package com.zhaolg5.singleton.userinfo.bean;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by zhaolg on 2018/5/17
 *
 * @return
 * @throws Exception
 */
@Entity
@Table(name = "BS_STATIC_DATA")
public class BsStaticData {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String codeType;

    @Column
    private String codeValue;

    @Column
    private String codeName;

    @Column
    private String codeDesc;

    @Column
    private int sortId;

    @Column
    private String state;

    @Column
    private Date createDate = new Date();


    public String getCodeType() {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    public String getCodeValue() {
        return codeValue;
    }

    public void setCodeValue(String codeValue) {
        this.codeValue = codeValue;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getCodeDesc() {
        return codeDesc;
    }

    public void setCodeDesc(String codeDesc) {
        this.codeDesc = codeDesc;
    }

    public int getSortId() {
        return sortId;
    }

    public void setSortId(int sortId) {
        this.sortId = sortId;
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
}
