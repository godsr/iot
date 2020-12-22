package com.ziumks.iot.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "comm_cd_info", schema = "iot_web")
public class TagUnit implements Serializable{

	private static final long serialVersionUID = 10L;
	
	@Id
	@Column(name="cd_id", length=32 )
	private String cdId;
	
	@Column(name="grup_cd", length=32 )
	private String grupCd;
	
	@Column(name="cd_nm", length=50 )
	private String cdNm;
	
	@Column(name="cd_desc", length=500 )
	private String cdDesc;

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
	
	
}
