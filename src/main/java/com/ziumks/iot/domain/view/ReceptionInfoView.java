package com.ziumks.iot.domain.view;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;



@Entity
@Table(name="DVC_INFO_VIEW")
public class ReceptionInfoView {

	@Id
	@Column(name="dvc_pk_id", length=32)
	private String devicePkId;
	@Column(name="dvc_id", length=64)
	private String deviceId;
	@Column(name="dvc_host", length=1024)
	private String deviceHost;
	@Column(name="end_point_uri", length=300)
	private String endPointUri;
	@Column(name="dvc_type", length=300)
    private String deviceType;
    @Column(name="model_nm", length=300 )
    private String modelNm;
    @Column(name="model_id", length=255 )
    private String modelId;
    @Column(name="dvc_nm", length=50 )
    private String dvcNm;
    @Column(name="dvc_use_yn", length=50 )
    private String dvcUseYn;
    @Column(name="cre_dtm", length=50 )
    private String creDtm;
    @Column(name="device_receive_id", length=50 )
    private String deviceReceiveId;
    
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns(value = {
			@JoinColumn(name = "client_cd", referencedColumnName = "client_cd", updatable = false, insertable = false),
			@JoinColumn(name = "site_cd", referencedColumnName = "site_cd", updatable = false, insertable = false)
	})
	@Embedded
    private ClientSiteView clientSiteView;    


	@Column(name="client_cd", length=32 )
	private String clientCd;


	@Column(name="site_cd", length=32 )
	private String siteCd;

	@Transient
	private List<String> streams;
	
	@Transient
	private String setupDeviceId;

    public String getDevicePkId() {
        return devicePkId;
    }

    public void setDevicePkId(String devicePkId) {
        this.devicePkId = devicePkId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceHost() {
        return deviceHost;
    }

    public void setDeviceHost(String deviceHost) {
        this.deviceHost = deviceHost;
    }

    public String getEndPointUri() {
        return endPointUri;
    }

    public void setEndPointUri(String endPointUri) {
        this.endPointUri = endPointUri;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getModelNm() {
        return modelNm;
    }

    public void setModelNm(String modelNm) {
        this.modelNm = modelNm;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public String getDvcNm() {
        return dvcNm;
    }

    public void setDvcNm(String dvcNm) {
        this.dvcNm = dvcNm;
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

    public List<String> getStreams() {
        return streams;
    }

    public void setStreams(List<String> streams) {
        this.streams = streams;
    }

    public String getSetupDeviceId() {
        return setupDeviceId;
    }

    public void setSetupDeviceId(String setupDeviceId) {
        this.setupDeviceId = setupDeviceId;
    }

    public String getDvcUseYn() {
        return dvcUseYn;
    }

    public void setDvcUseYn(String dvcUseYn) {
        this.dvcUseYn = dvcUseYn;
    }

    public String getCreDtm() {
        return creDtm;
    }

    public void setCreDtm(String creDtm) {
        this.creDtm = creDtm;
    }

    public ClientSiteView getClientSiteView() {
        return clientSiteView;
    }

    public void setClientSiteView(ClientSiteView clientSiteView) {
        this.clientSiteView = clientSiteView;
    }

    public String getDeviceReceiveId() {
        return deviceReceiveId;
    }

    public void setDeviceReceiveId(String deviceReceiveId) {
        this.deviceReceiveId = deviceReceiveId;
    }
    
}