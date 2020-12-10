package com.ziumks.iot.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="dvc_info", schema="iot_web")
public class DvcInfo implements Serializable {

    private static final long serialVersionUID = -9113214440020084771L;


    @Id
    @Column(name="dvc_pk_id", length=32 )
    private String dvcPkId; // 디바이스 관리 pk 아이디

    @Column(name="dvc_id", length=64 )
    private String dvcId; // 디바이스 아이디

    @Column(name="node_resource_id", length=500 )
    private String nodeResourceId;	// node resource id

    @Column(name="deviceinfo_resource_id", length=500 )
    private String deviceInfoResourceId;	// deviceInfo resource 아이디

    @Column(name="ae_resource_id", length=500 )
    private String aeResourceId;	// Ae Resource id

    @Column(name="acp_resource_id", length=500 )
    private String acpResourceId;	// AccessContorolPolicy resource 아이디

    @Column(name="dvc_nm", length=50 )
    private String dvcNm;	//

    @Column(name="dvc_st", length=10 )
    private String dvcSt;	//

    @Column(name="last_active_time", length=17 )
    private String lastActiveTime;	//

    @Column(name="dvc_use_yn", length=10 )
    private String dvcUseYn;	//

    @Column(name="model_nm", length=300 )
    private String modelNm;	//

    @Column(name = "ptcl_type", length = 50)
    private String ptclType; // 프로토콜 유형

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

    @Column(name = "srial_nm", length = 300)
    private String srialNm;

    @Column(name = "supply_co", length = 300)
    private String supplyCo;

    @Column(name="client_cd", length=32 )
    private String clientCd;

    @Column(name="site_cd", length=32 )
    private String siteCd;

    @Column(name="cremn", length=32 )
    private String creMn;

    @Column(name="cre_dtm", length=32 )
    private String creDtm;

    @Column(name="updmn", length=32 )
    private String updMn;

    @Column(name="upd_dtm", length=32 )
    private String updDtm;

	/*@JsonIgnore
	@OneToMany(mappedBy="dvcInfo" , fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private List<ThresholdInfo> thresholdInfos;*/

    @OneToMany(mappedBy="dvcInfo" , fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<StreamInfo> streamInfos;


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

    public String getModelNm() {
        return modelNm;
    }

    public void setModelNm(String modelNm) {
        this.modelNm = modelNm;
    }

//    public List<StreamInfo> getStreamInfos() {
//        return streamInfos;
//    }
//
//    public void setStreamInfos(List<StreamInfo> streamInfos) {
//        this.streamInfos = streamInfos;
//    }

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

	/*public List<ThresholdInfo> getThresholdInfos() {
		return thresholdInfos;
	}

	public void setThresholdInfos(List<ThresholdInfo> thresholdInfos) {
		this.thresholdInfos = thresholdInfos;
	}*/

    public String getDvcId() {
        return dvcId;
    }

    public void setDvcId(String dvcId) {
        this.dvcId = dvcId;
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
