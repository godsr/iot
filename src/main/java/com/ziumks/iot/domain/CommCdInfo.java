package com.ziumks.iot.domain;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="comm_cd_info", schema = "iot_web")
public class CommCdInfo implements Serializable {

	private static final long serialVersionUID = 770993451135751704L;

	@Id
	@Column(name="cd_id", length=32 )
	private String cdId;
	
	@Column(name="grup_cd", length=32 )
	private String grupCd;
	
	@Column(name="grup_yn", length=1 , columnDefinition="char" )
	private String grupYn;
	
	@Column(name="cd", length=32 )
	private String cd;
	
	@Column(name="cd_nm", length=50 )
	private String cdNm;
	
	@Column(name="cd_desc", length=500 )
	private String cdDesc;
	
	@Column(name="sort", columnDefinition="numeric" )
	private Integer sort;
	
	@Column(name="use_yn", length=1 , columnDefinition="char" )
	private String useYn;
	
	@Column(name="cremn", length=32 )
	private String creMn;
	
	@Column(name="cre_dtm", length=32 )
	private String creDtm;
	
	@Column(name="updmn", length=32 )
	private String updMn;
	
	@Column(name="upd_dtm", length=32 )
	private String updDtm;

	public String getCdId() {
		return cdId;
	}

	public void setCdId(String cdId) {
		this.cdId = cdId;
	}

	public String getGrupCd() {
		return grupCd;
	}

	public void setGrupCd(String grupCd) {
		this.grupCd = grupCd;
	}

	public String getGrupYn() {
		return grupYn;
	}

	public void setGrupYn(String grupYn) {
		this.grupYn = grupYn;
	}

	public String getCd() {
		return cd;
	}

	public void setCd(String cd) {
		this.cd = cd;
	}

	public String getCdNm() {
		return cdNm;
	}

	public void setCdNm(String cdNm) {
		this.cdNm = cdNm;
	}

	public String getCdDesc() {
		return cdDesc;
	}

	public void setCdDesc(String cdDesc) {
		this.cdDesc = cdDesc;
	}

//	public String getSort() {
//		return sort;
//	}
//
//	public void setSort(String sort) {
//		this.sort = sort;
//	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getSort() {
		return sort;
	}

	public String getUseYn() {
		return useYn;
	}

	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}

	public String getCreMn() {
		return creMn;
	}

	public void setCreMn(String creMn) {
		this.creMn = creMn;
	}

	public String getCreDtm() {
		return creDtm;
	}

	public void setCreDtm(String creDtm) {
		this.creDtm = creDtm;
	}

	public String getUpdMn() {
		return updMn;
	}

	public void setUpdMn(String updMn) {
		this.updMn = updMn;
	}

	public String getUpdDtm() {
		return updDtm;
	}

	public void setUpdDtm(String updDtm) {
		this.updDtm = updDtm;
	}

}
