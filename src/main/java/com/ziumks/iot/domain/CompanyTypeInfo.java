package com.ziumks.iot.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="co_type_info", schema = "iot_web")
public class CompanyTypeInfo implements Serializable {

    private static final long serialVersionUID = -9113214440020084771L;

    @Id
    @Column(name = "co_type_id", length = 32)
    private String coTypeId;

    @Column(name = "co_type_cd", length = 255, unique = true)
    private String coTypeCd;

    @Column(name = "co_type_nm", length = 255)
    private String coTypeNm;

    @Column(name = "cremn", length = 32)
    private String cremn;

    public String getCoTypeId() {
        return coTypeId;
    }

    public void setCoTypeId(String coTypeId) {
        this.coTypeId = coTypeId;
    }

    public String getCoTypeCd() {
        return coTypeCd;
    }

    public void setCoTypeCd(String coTypeCd) {
        this.coTypeCd = coTypeCd;
    }

    public String getCoTypeNm() {
        return coTypeNm;
    }

    public void setCoTypeNm(String coTypeNm) {
        this.coTypeNm = coTypeNm;
    }

    public String getCremn() {
        return cremn;
    }

    public void setCremn(String cremn) {
        this.cremn = cremn;
    }
}
