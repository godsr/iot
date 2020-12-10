package com.ziumks.iot.domain.view;

import com.google.common.base.Strings;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="client_site_view", schema = "iot_web")
public class ClientSiteView implements Serializable {

	private static final long serialVersionUID = -9113214440020084771L;

	@Column(name="client_cd", length=32 )
	private String clientCd;
	
	@Column(name="client_nm", length=32 )
	private String clientNm;

	@Column(name="client_info", length=32 )
	private String clientInfo;

	@Id
	@Column(name="site_cd", length=32 )
	private String siteCd;

	@Column(name="site_nm", length=32 )
	private String siteNm;

	@Column(name="site_info", length=32 )
	private String siteInfo;

	@Transient
	private String clientDisplayNm;

	@Transient
	private String siteDisplayNm;

	public String getClientCd() { return clientCd; }

	public void setClientCd(String clientCd) { this.clientCd = clientCd; }

	public String getClientNm() { return clientNm; }

	public void setClientNm(String clientNm) { this.clientNm = clientNm; }

	public String getClientInfo() { return clientInfo; }

	public void setClientInfo(String clientInfo) { this.clientInfo = clientInfo; }

	public String getSiteCd() { return siteCd; }

	public void setSiteCd(String siteCd) { this.siteCd = siteCd; }

	public String getSiteNm() { return siteNm; }

	public void setSiteNm(String siteNm) { this.siteNm = siteNm; }

	public String getSiteInfo() { return siteInfo; }

	public void setSiteInfo(String siteInfo) { this.siteInfo = siteInfo; }

	public String getClientDisplayNm() {
		if(Strings.isNullOrEmpty(clientCd) || Strings.isNullOrEmpty(clientNm))
			return "";
		else
			return clientNm+" ("+ clientCd +")";
	}

	public void setClientDisplayNm(String clientDisplayNm) {
		this.clientDisplayNm = clientDisplayNm;
	}

	public String getSiteDisplayNm() {
		if(Strings.isNullOrEmpty(siteCd) || Strings.isNullOrEmpty(siteNm))
			return "";
		else
			return siteNm+" ("+ siteCd +")";
	}

	public void setSiteDisplayNm(String siteDisplayNm) {
		this.siteDisplayNm = siteDisplayNm;
	}
}
