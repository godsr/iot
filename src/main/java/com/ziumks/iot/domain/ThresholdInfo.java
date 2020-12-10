package com.ziumks.iot.domain;


import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="threshold_info", schema = "iot_web")
public class ThresholdInfo implements Serializable {

	private static final long serialVersionUID = -3722795413980478339L;

	@Id
	@Column(name="threshold_id", length=32 )
	private String thresholdId; // 임계치 pk 아이디
	
	@Column(name="dvc_pk_id", length=32 )
	private String dvcPkId;	// 디바이스 pk 아이디 
	
	@Column(name="stream_pk_id", length=256 )
	private String streamPkId;	// 스트림 pk 아이디

	@Column(name="tag_id", length=500 )
	private String tagId;	// 센싱태그 아이디
	
	@Column(name="min_val", length=500 )
	private String minVal;	// 최소 값
	
	@Column(name="max_val", length=50 )
	private String maxVal;	// 최대 값
	
	@Column(name="cremn", length=32 )
	private String creMn;
	
	@Column(name="cre_dtm", length=32 )
	private String creDtm;
	
	@Column(name="updmn", length=32 )
	private String updMn;
	
	@Column(name="upd_dtm", length=32 )
	private String updDtm;

	/*@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="dvc_pk_id", updatable = false, insertable = false)
	DvcInfo dvcInfo;*/

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="stream_pk_id", updatable = false, insertable = false)
	StreamInfo streamInfo;

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

	public String getThresholdId() {
		return thresholdId;
	}

	public void setThresholdId(String thresholdId) {
		this.thresholdId = thresholdId;
	}

	public String getDvcPkId() {
		return dvcPkId;
	}

	public void setDvcPkId(String dvcPkId) {
		this.dvcPkId = dvcPkId;
	}

	public String getStreamPkId() {
		return streamPkId;
	}

	public void setStreamPkId(String streamPkId) {
		this.streamPkId = streamPkId;
	}

	public String getTagId() {
		return tagId;
	}

	public void setTagId(String tagId) {
		this.tagId = tagId;
	}

	public String getMinVal() {
		return minVal;
	}

	public void setMinVal(String minVal) {
		this.minVal = minVal;
	}

	public String getMaxVal() {
		return maxVal;
	}

	public void setMaxVal(String maxVal) {
		this.maxVal = maxVal;
	}

	public StreamInfo getStreamInfo() {
		return streamInfo;
	}

	public void setStreamInfo(StreamInfo streamInfo) {
		this.streamInfo = streamInfo;
	}

	/*public DvcInfo getDvcInfo() {
		return dvcInfo;
	}

	public void setDvcInfo(DvcInfo dvcInfo) {
		this.dvcInfo = dvcInfo;
	}*/
	
	
	
	
}