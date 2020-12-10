package com.ziumks.iot.domain.view;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;


import com.ziumks.iot.config.CommonCode;
import com.ziumks.iot.domain.CompanyInfo;
import org.hibernate.annotations.Formula;

@Entity
@Table(name="dvc_info_view")
public class DvcInfoView implements Serializable {

	private static final long serialVersionUID = -9113214440020084771L;

	@Id
	@Column(name="dvc_pk_id", length=32 )
	private String dvcPkId; // 디바이스 관리 pk 아이디
	
	@Column(name="dvc_id", length=32 )
	private String dvcId; // 디바이스 아이디
	
	@Column(name="node_resource_id", length=500 )
	private String nodeResourceId;	// node resource id
	
	@Column(name="deviceinfo_resource_id", length=500 )
	private String deviceInfoResourceId;	// deviceInfo resource 아이디
	
	@Column(name="ae_resource_id", length=500 )
	private String aeResourceId;	// Ae Resource id 
	
	@Column(name="acp_resource_id", length=500 )
	private String acpResourceId;	// AccessContorolPolicy resource 아이디

//	@NotNull(message = "{device.name.set}", groups = {Create.class, Update.class })
	@Column(name="dvc_nm", length=50 )
	private String dvcNm;	// 디바이스 명
	
//	@ContactNumberConstraint(message = "8~14자리의 숫자만 입력가능합니다", groups={Create.class})
//	@Pattern(regexp = "[0-9]{10,11}", message = "10~11자리의 숫자만 입력가능합니다", groups={Create.class})
	@Column(name="dvc_st", length=10 )
	private String dvcSt;	// 디바이스 상태
	
	@Column(name="last_active_time", length=17 )
	private String lastActiveTime;	// 마지막 구동 시간 
	
	@Column(name="desc", length=255 )
	private String desc;	//oneM2M 디바이스 설명 
	
	@Column(name="dvc_type", length=255 )
	private String dvcType;	//oneM2M 디바이스 유형

	// @Transient
	@Formula("(select iot_web.get_dvc_type_nm(dvc_type, '"+ CommonCode.GRUP_CD.DEVICE_TYPE+"'))")
	private String dvcTypeNm; // 시설물 유형 명

	@Column(name="manu", length=255 )
	private String manu;	//oneM2M 제조자
	
	@Column(name="dvc_use_yn", length=10 )
	private String dvcUseYn;	// 
	
	@Column(name="model_nm", length=300 )
	private String modelNm;	// 
	
	@Column(name="model_id", length=255 )
	private String modelId;	//oneM2M 모델
	
	@Column(name = "ptcl_type", length = 50)
	private String ptclType; // 프로토콜 유형

	@Formula("(SELECT cci.cd_nm FROM iot_web.comm_cd_info AS cci WHERE cci.grup_cd='"+CommonCode.GRUP_CD.DeviceProtocolType+"' AND cci.cd = ptcl_type)")
	private String ptclTypeNm; // 프로토콜 유형 명

	@Column(name = "coordx", length = 32)
	private String coordx; //좌표 X (경도/lon)
	
	@Column(name = "coordy", length = 32)
	private String coordy; //좌표 y (위도/lat)
	
	@Column(name = "coordz", length = 32)
	private String coordz; //좌표 z
	
	@Column(name = "loc", length = 300)
	private String locate;

	@Column(name = "loc_detail", length = 300)
	private String locateDetail;
	
	@Column(name="aeid", length=255 )
	private String aeID;	//oneM2M AE-ID
	
//	@Column(name="dvc_host", length=1024 )
//	List<String> dvcHost;	//oneM2M  pointofaccess // 디바이스 호스트

	@Column(name = "srial_nm", length = 300)
	private String srialNm;

	@Column(name = "supply_co", length = 300)
	private String supplyCo;

	@Transient
	private String iotServerHost; // iot 서버 호스트정보

	@Column(name="end_point_uri", length=255 )
	private String endPointUri;	//oneM2M AE end point uri
	
	@Column(name="security_end_point_uri", length=255 )
	private String securityEndPointUri;	//oneM2M AE end point uri
	
	@Column(name="cremn", length=32 )
	private String creMn;
	
	@Column(name="cre_dtm", length=32 )
	private String creDtm;
	
	@Column(name="updmn", length=32 )
	private String updMn;
	
	@Column(name="upd_dtm", length=32 )
	private String updDtm;


	@Column(name="client_cd", length=32 )
	private String clientCd;


	@Column(name="site_cd", length=32 )
	private String siteCd;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns(value = {
			@JoinColumn(name = "client_cd", referencedColumnName = "client_cd", updatable = false, insertable = false),
			@JoinColumn(name = "site_cd", referencedColumnName = "site_cd", updatable = false, insertable = false)
	})
	@Embedded
	private ClientSiteView clientSiteView;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "dvc_pk_id", referencedColumnName = "dvc_pk_id", updatable = false, insertable = false)
	@Embedded
	private List<StreamInfoView> streamInfos;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "supply_co", referencedColumnName = "co_id", updatable = false, insertable = false)
	@Embedded
	private CompanyInfo companyInfo;
	
	@Transient
	private String creDtmView;
	
	@Transient
	private String updDtmView;

	@Transient
	private String facClfyId;
	
	
	public List<StreamInfoView> getStreamInfos() {
		return streamInfos;
	}

	public void setStreamInfos(List<StreamInfoView> streamInfos) {
		this.streamInfos = streamInfos;
	}

	public String getFacClfyId() {
		return facClfyId;
	}

	public void setFacClfyId(String facClfyId) {
		this.facClfyId = facClfyId;
	}

	public String getIotServerHost() {
		return iotServerHost;
	}

	public void setIotServerHost(String iotServerHost) {
		this.iotServerHost = iotServerHost;
	}

	public String getPtclTypeNm() {
		return ptclTypeNm;
	}

	public String getDvcTypeNm() {
		return dvcTypeNm;
	}

	public void setPtclTypeNm(String ptclTypeNm) {
		this.ptclTypeNm = ptclTypeNm;
	}

	public void setDvcTypeNm(String dvcTypeNm) {
		this.dvcTypeNm = dvcTypeNm;
	}

	public String getDvcPkId() {
		return dvcPkId;
	}

	public void setDvcPkId(String dvcPkId) {
		this.dvcPkId = dvcPkId;
	}

	public String getPtclType() {
		return ptclType;
	}

	public void setPtclType(String ptclType) {
		this.ptclType = ptclType;
	}

	public String getCoordx() {
		return coordx;
	}

	public void setCoordx(String coordx) {
		this.coordx = coordx;
	}

	public String getCoordy() {
		return coordy;
	}

	public void setCoordy(String coordy) {
		this.coordy = coordy;
	}

	public String getCoordz() {
		return coordz;
	}

	public void setCoordz(String coordz) {
		this.coordz = coordz;
	}

	public String getLocate() {
		return locate;
	}

	public void setLocate(String locate) {
		this.locate = locate;
	}

	public String getDvcUseYn() {
		return dvcUseYn;
	}

	public void setDvcUseYn(String dvcUseYn) {
		this.dvcUseYn = dvcUseYn;
	}

	public String getEndPointUri() {
		return endPointUri;
	}

	public void setEndPointUri(String endPointUri) {
		this.endPointUri = endPointUri;
	}

	public String getSecurityEndPointUri() {
		return securityEndPointUri;
	}

	public void setSecurityEndPointUri(String securityEndPointUri) {
		this.securityEndPointUri = securityEndPointUri;
	}

	public String getNodeResourceId() {
		return nodeResourceId;
	}

	public void setNodeResourceId(String nodeResourceId) {
		this.nodeResourceId = nodeResourceId;
	}

	public String getDeviceInfoResourceId() {
		return deviceInfoResourceId;
	}

	public void setDeviceInfoResourceId(String deviceInfoResourceId) {
		this.deviceInfoResourceId = deviceInfoResourceId;
	}

	public String getAeResourceId() {
		return aeResourceId;
	}

	public void setAeResourceId(String aeResourceId) {
		this.aeResourceId = aeResourceId;
	}

	public String getAcpResourceId() {
		return acpResourceId;
	}

	public void setAcpResourceId(String acpResourceId) {
		this.acpResourceId = acpResourceId;
	}

	public String getDvcNm() {
		return dvcNm;
	}

	public void setDvcNm(String dvcNm) {
		this.dvcNm = dvcNm;
	}

	public String getDvcSt() {
		return dvcSt;
	}

	public void setDvcSt(String dvcSt) {
		this.dvcSt = dvcSt;
	}

	public String getLastActiveTime() {
		return lastActiveTime;
	}

	public void setLastActiveTime(String lastActiveTime) {
		this.lastActiveTime = lastActiveTime;
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

	public String getDvcId() {
		return dvcId;
	}

	public void setDvcId(String dvcId) {
		this.dvcId = dvcId;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getDvcType() {
		return dvcType;
	}

	public void setDvcType(String dvcType) {
		this.dvcType = dvcType;
	}

	public String getManu() {
		return manu;
	}

	public void setManu(String manu) {
		this.manu = manu;
	}

	public String getModelId() {
		return modelId;
	}

	public void setModelId(String modelId) {
		this.modelId = modelId;
	}

	public String getAeID() {
		return aeID;
	}

	public void setAeID(String aeID) {
		this.aeID = aeID;
	}

//	public List<String> getDvcHost() {
//		return dvcHost;
//	}
//
//	public void setDvcHost(List<String> dvcHost) {
//		this.dvcHost = dvcHost;
//	}

	public String getModelNm() {
		return modelNm;
	}

	public void setModelNm(String modelNm) {
		this.modelNm = modelNm;
	}

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

	public ClientSiteView getClientSiteView() {
		return clientSiteView;
	}

	public void setClientSiteView(ClientSiteView clientSiteView) {
		this.clientSiteView = clientSiteView;
	}

	public String getLocateDetail() {
		return locateDetail;
	}

	public void setLocateDetail(String locateDetail) {
		this.locateDetail = locateDetail;
	}

	public String getSrialNm() {
		return srialNm;
	}

	public void setSrialNm(String srialNm) {
		this.srialNm = srialNm;
	}

	public String getSupplyCo() {
		return supplyCo;
	}

	public void setSupplyCo(String supplyCo) {
		this.supplyCo = supplyCo;
	}

	public CompanyInfo getCompanyInfo() {
		return companyInfo;
	}

	public void setCompanyInfo(CompanyInfo companyInfo) {
		this.companyInfo = companyInfo;
	}
}
