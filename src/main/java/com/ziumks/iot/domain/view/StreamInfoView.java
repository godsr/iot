package com.ziumks.iot.domain.view;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


import com.ziumks.iot.config.CommonCode;
import org.hibernate.annotations.Formula;

@Entity
@Table(name="stream_info_view")
public class StreamInfoView implements Serializable, Comparable<StreamInfoView> {

	private static final long serialVersionUID = 4014253989722780702L;

	@Id
	@Column(name="stream_pk_id", length=32 )
	private String streamPkId;
	
	@Column(name="dvc_pk_id", length=256 )
	private String dvcPkId;	// 디바이스 아이디
	
	@Column(name="container_resource_id", length=500 )
	private String containerResourceId;
	
	@Column(name="container_structure_resource_id", length=500 )
	private String containerStructureResourceId;
	
	@Column(name="stream_id", length=128 )
	private String streamId;
	
	@Column(name="stream_nm", length=300 )
	private String streamNm;

	@Column(name="stream_desc", length=500 )
	private String streamDesc;
	
	@Column(name="stream_unit", length=50 )
	private String streamUnit;

	@Column(name="stream_unit_nm", length=50 )
	private String streamUnitNm;

	@Column(name="stream_collection_period", length=50 )
	private String streamCollectionPeriod;
	
	@Column(name="stream_type", length=50 )
	private String streamType;

	@Formula("(SELECT cci.cd_nm FROM iot_web.comm_cd_info AS cci WHERE cci.grup_cd='"+ CommonCode.GRUP_CD.TagType+"' AND cci.cd = stream_type)")
	private String streamTypeNm;

	@Column(name="cremn", length=32 )
	private String creMn;
	
	@Column(name="cre_dtm", length=32 )
	private String creDtm;
	
	@Column(name="updmn", length=32 )
	private String updMn;
	
	@Column(name="upd_dtm", length=32 )
	private String updDtm; 
	
	@Column(name="ae_resource_id", length=500 )
	private String aeResourceId;

	@Column(name="stream_data_type", length=50 )
	private String streamDataType;

	@Formula("(SELECT cci.cd_nm FROM iot_web.comm_cd_info AS cci WHERE cci.grup_cd='"+CommonCode.GRUP_CD.DEVICE_TYPE+"' AND cci.cd = stream_data_type)")
	private String streamDataTypeNm;

	@Transient
	private String creDtmView;
	
	@Transient
	private String updDtmView;
	
	
	public String getContainerStructureResourceId() {
		return containerStructureResourceId;
	}

	public void setContainerStructureResourceId(String containerStructureResourceId) {
		this.containerStructureResourceId = containerStructureResourceId;
	}

	public String getStreamUnitNm() {
		return streamUnitNm;
	}

	public void setStreamUnitNm(String streamUnitNm) {
		this.streamUnitNm = streamUnitNm;
	}

	public String getStreamTypeNm() {
		return streamTypeNm;
	}

	public void setStreamTypeNm(String streamTypeNm) {
		this.streamTypeNm = streamTypeNm;
	}

	public String getAeResourceId() {
		return aeResourceId;
	}

	public void setAeResourceId(String aeResourceId) {
		this.aeResourceId = aeResourceId;
	}

	public String getStreamPkId() {
		return streamPkId;
	}

	public void setStreamPkId(String streamPkId) {
		this.streamPkId = streamPkId;
	}

	public String getDvcPkId() {
		return dvcPkId;
	}

	public void setDvcPkId(String dvcPkId) {
		this.dvcPkId = dvcPkId;
	}

	public String getContainerResourceId() {
		return containerResourceId;
	}

	public void setContainerResourceId(String containerResourceId) {
		this.containerResourceId = containerResourceId;
	}

	public String getStreamId() {
		return streamId;
	}

	public void setStreamId(String streamId) {
		this.streamId = streamId;
	}

	public String getStreamNm() {
		return streamNm;
	}

	public void setStreamNm(String streamNm) {
		this.streamNm = streamNm;
	}

	public String getStreamDesc() {
		return streamDesc;
	}

	public void setStreamDesc(String streamDesc) {
		this.streamDesc = streamDesc;
	}

	public String getStreamUnit() {
		return streamUnit;
	}

	public void setStreamUnit(String streamUnit) {
		this.streamUnit = streamUnit;
	}

	public String getStreamCollectionPeriod() {
		return streamCollectionPeriod;
	}

	public void setStreamCollectionPeriod(String streamCollectionPeriod) {
		this.streamCollectionPeriod = streamCollectionPeriod;
	}

	public String getStreamType() {
		return streamType;
	}

	public void setStreamType(String streamType) {
		this.streamType = streamType;
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

	public String getStreamDataType() {
		return streamDataType;
	}

	public void setStreamDataType(String streamDataType) {
		this.streamDataType = streamDataType;
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

	public String getStreamDataTypeNm() {
		return streamDataTypeNm;
	}

	public void setStreamDataTypeNm(String streamDataTypeNm) {
		this.streamDataTypeNm = streamDataTypeNm;
	}

	@Override
	public int compareTo(StreamInfoView o) {
		return this.streamId.compareTo(o.getStreamId());
	}
	
}
