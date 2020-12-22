package com.ziumks.iot.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="oms_client_info", schema="oms")
public class ClientCd implements Serializable{

	
	@Id
	@Column(name="client_cd", length = 10)
	private String clientCd;
	
	@Column(name="client_nm", length = 10)
	private String clientNm;
	
	public String getClientCd() {
		return clientCd;
	}

	public void setClientCd(String clientCd) {
		this.clientCd = clientCd;
	}

	public String getClientNm() {
		return clientNm;
	}

	public void setClientNm(String clientNm) {
		this.clientNm = clientNm;
	}

	private static final long serialVersionUID = 3L;
	
}
