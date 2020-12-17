package com.ziumks.iot.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Where;

import com.ziumks.iot.config.CommonCode;
import com.ziumks.iot.domain.view.ClientSiteView;



@Entity
@Table(name="erf_co_info", schema = "fms")
public class CompanyInfo  implements Serializable {

    private static final long serialVersionUID = -9113214440020084771L;

    @Id
    @Column(name = "co_id", length = 255)
    private String coId;

    @Column(name = "co_nm", length = 255)
    private String coNm;

    @Column(name = "co_gb", length = 255)
    private String coType;

    @Column(name = "co_phone", length = 255)
    private String coPhone;

    @Column(name = "addr", length = 500)
    private String coAddr;

    @Column(name = "cjobmn", length = 255)
    private String coMngr;

    @Column(name = "cjobmn_phone", length = 255)
    private String coMngrPhone;

    @Column(name = "email", length = 255)
    private String coMngrEmail;

    @Column(name = "client_cd", length = 255)
    private String clientCd;

    @Column(name = "site_cd", length = 255)
    private String siteCd;

    @Column(name = "reg_dtm", length = 255)
    private String creDtm;

    @Column(name = "upd_dtm", length = 255)
    private String updDtm;

    @Column(name = "regrt", length = 50)
    private String regrt;

    @Column(name = "use_yn")
    private Boolean use_yn;

    @Transient
    private String creDtmView;

    @Transient
    private String updDtmView;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumns(value = {
//            @JoinColumn(name = "client_cd", referencedColumnName = "client_cd", updatable = false, insertable = false),
//            @JoinColumn(name = "site_cd", referencedColumnName = "site_cd", updatable = false, insertable = false)
//    })
//    @Embedded
//    private ClientSiteView clientSiteView;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "co_gb", referencedColumnName = "cd", updatable = false, insertable = false)
    @Where(clause = "grup_cd = '"+ CommonCode.GRUP_CD.CompanyType+"'")
    @Embedded
//  @Formula("(select CMCD.cdNm from IOT.CommCdInfo CMCD where CMCD.grupCd = 'IOT006' AND CMCD.cd = 'coType')")
    private CommCdInfo companyTypeInfo;

    public String getCoId() {
        return coId;
    }

    public void setCoId(String coId) {
        this.coId = coId;
    }

    public String getCoNm() {
        return coNm;
    }

    public void setCoNm(String coNm) {
        this.coNm = coNm;
    }

    public String getCoType() {
        return coType;
    }

    public void setCoType(String coType) {
        this.coType = coType;
    }

    public String getCoPhone() {
        return coPhone;
    }

    public void setCoPhone(String coPhone) {
        this.coPhone = coPhone;
    }

    public String getCoAddr() {
        return coAddr;
    }

    public void setCoAddr(String coAddr) {
        this.coAddr = coAddr;
    }

    public String getCoMngr() {
        return coMngr;
    }

    public void setCoMngr(String coMngr) {
        this.coMngr = coMngr;
    }

    public String getCoMngrPhone() {
        return coMngrPhone;
    }

    public void setCoMngrPhone(String coMngrPhone) {
        this.coMngrPhone = coMngrPhone;
    }

    public String getCoMngrEmail() {
        return coMngrEmail;
    }

    public void setCoMngrEmail(String coMngrEmail) {
        this.coMngrEmail = coMngrEmail;
    }

    public String getClientCd() {
        return clientCd;
    }

    public void setClientCd(String clientCd) {
        this.clientCd = clientCd;
    }

    public String getSiteCd() {
        return siteCd;
    }

    public void setSiteCd(String siteCd) {
        this.siteCd = siteCd;
    }

    public String getCreDtm() {
        return creDtm;
    }

    public void setCreDtm(String creDtm) {
        this.creDtm = creDtm;
    }

    public String getUpdDtm() {
        return updDtm;
    }

    public void setUpdDtm(String updDtm) {
        this.updDtm = updDtm;
    }

//    public ClientSiteView getClientSiteView() {
//        return clientSiteView;
//    }

//    public void setClientSiteView(ClientSiteView clientSiteView) {
//        this.clientSiteView = clientSiteView;
//    }

    public String getCreDtmView() {
        return creDtmView;
    }

    public void setCreDtmView(String creDtmView) {
        this.creDtmView = creDtmView;
    }

    public String getUpdDtmView() {
        return updDtmView;
    }

    public void setUpdDtmView(String updDtmView) {
        this.updDtmView = updDtmView;
    }

    public String getRegrt() {
        return regrt;
    }

    public void setRegrt(String regrt) {
        this.regrt = regrt;
    }

    public Boolean getUse_yn() {
        return use_yn;
    }

    public void setUse_yn(Boolean use_yn) {
        this.use_yn = use_yn;
    }

    public CommCdInfo getCompanyTypeInfo() {
        return companyTypeInfo;
    }

    public void setCompanyTypeInfo(CommCdInfo companyTypeInfo) {
        this.companyTypeInfo = companyTypeInfo;
    }
}
