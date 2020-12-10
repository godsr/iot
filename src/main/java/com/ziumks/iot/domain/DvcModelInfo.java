package com.ziumks.iot.domain;


import com.ziumks.iot.config.CommonCode;
import com.ziumks.iot.domain.view.ClientSiteView;
import com.ziumks.iot.domain.view.DvcInfoView;
import org.hibernate.annotations.Formula;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "dvc_model_info", schema = "iot_web")
public class DvcModelInfo implements Serializable {

	private static final long serialVersionUID = -2861675854717593136L;

	@Id
	@Column(name = "dvc_model_id", length = 32)
	private String dvcModelId; // 모델 pk 아이디

	@Column(name = "model_id", length = 64)
	private String modelId; // 모델 아이디

	@Column(name = "model_nm", length = 300)
	private String modelNm; // 모델 명

	@Column(name = "model_desc", length = 500)
	private String modelDesc; // 모델 설명

	@Column(name = "manu", length = 50)
	private String manu; // 제조사

	@Column(name = "dvc_type", length = 300)
	private String dvcType; // 디바이스 유형

	@Transient
	@Formula("(select iot_web.get_dvc_type_nm(dvc_type, '"+ CommonCode.GRUP_CD.DEVICE_TYPE+"'))")
	private String dvcTypeNm; // 디바이스 유형 명

	@Column(name = "ptcl_type", length = 50)
	private String ptclType; // 프로토콜 유형

	@Formula("(SELECT cci.cd_nm FROM iot_web.comm_cd_info AS cci WHERE cci.grup_cd='"+CommonCode.GRUP_CD.DeviceProtocolType+"' AND cci.cd = ptcl_type)")
	private String ptclTypeNm; // 프로토콜 유형 명

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

	public ClientSiteView getClientSiteView() {
		return clientSiteView;
	}

	public void setClientSiteView(ClientSiteView clientSiteView) {
		this.clientSiteView = clientSiteView;
	}

	@OneToMany(mappedBy="dvcModelInfo" , fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private List<TagModelMappInfo> tagModelMappInfos;

	@Transient
	private List<DvcInfoView> dvcInfoViews;

	public List<DvcInfoView> getDvcInfoViews() {
		return dvcInfoViews;
	}

	public void setDvcInfoViews(List<DvcInfoView> dvcInfoViews) {
		this.dvcInfoViews = dvcInfoViews;
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

	public List<TagModelMappInfo> getTagModelMappInfos() {
		return tagModelMappInfos;
	}

	public void setTagModelMappInfos(List<TagModelMappInfo> tagModelMappInfos) {
		this.tagModelMappInfos = tagModelMappInfos;
	}

	public String getDvcModelId() {
		return dvcModelId;
	}

	public void setDvcModelId(String dvcModelId) {
		this.dvcModelId = dvcModelId;
	}

	public String getModelId() {
		return modelId;
	}

	public void setModelId(String modelId) {
		this.modelId = modelId;
	}

	public String getModelNm() {
		return modelNm;
	}

	public void setModelNm(String modelNm) {
		this.modelNm = modelNm;
	}

	public String getModelDesc() {
		return modelDesc;
	}

	public void setModelDesc(String modelDesc) {
		this.modelDesc = modelDesc;
	}

	public String getManu() {
		return manu;
	}

	public void setManu(String manu) {
		this.manu = manu;
	}

	public String getPtclType() {
		return ptclType;
	}

	public void setPtclType(String ptclType) {
		this.ptclType = ptclType;
	}

	public String getPtclTypeNm() {
		return ptclTypeNm;
	}

	public void setPtclTypeNm(String ptclTypeNm) {
		this.ptclTypeNm = ptclTypeNm;
	}

	public String getDvcType() {
		return dvcType;
	}

	public void setDvcType(String dvcType) {
		this.dvcType = dvcType;
	}

	public String getDvcTypeNm() {
		return dvcTypeNm;
	}

	public void setDvcTypeNm(String dvcTypeNm) {
		this.dvcTypeNm = dvcTypeNm;
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
}
