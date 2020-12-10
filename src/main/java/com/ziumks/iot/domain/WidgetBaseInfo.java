package com.ziumks.iot.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="widget_base_info", schema = "iot_web")
public class WidgetBaseInfo implements Serializable{

	private static final long serialVersionUID = 3617315414661407571L;

	@Id
	@Column(name="widget_base_id", length=32)
	private String widgetBaseId;
	
	@Column(name="widget_base_URI", length=500)
	private String widgetBaseURI;
	
	@Column(name="widget_base_nm", length=300)
	private String widgetBaseNm;
	
	@Column(name="widget_base_desc", length=500)
	private String widgetBaseDesc;
	
	@Column(name="widget_type", length=2)
	private String widgetType;
	
	@Column(name="cremn", length=32 )
	private String creMn;
	
	@Column(name="cre_dtm", length=32 )
	private String creDtm;
	
	@Column(name="updmn", length=32 )
	private String updMn;
	
	@Column(name="upd_dtm", length=32 )
	private String updDtm;
	
	public String getWidgetType() {
		return widgetType;
	}

	public void setWidgetType(String widgetType) {
		this.widgetType = widgetType;
	}

	public String getWidgetBaseId() {
		return widgetBaseId;
	}

	public void setWidgetBaseId(String widgetBaseId) {
		this.widgetBaseId = widgetBaseId;
	}

	public String getWidgetBaseNm() {
		return widgetBaseNm;
	}

	public void setWidgetBaseNm(String widgetBaseNm) {
		this.widgetBaseNm = widgetBaseNm;
	}

	public String getWidgetBaseDesc() {
		return widgetBaseDesc;
	}

	public void setWidgetBaseDesc(String widgetBaseDesc) {
		this.widgetBaseDesc = widgetBaseDesc;
	}

	public String getWidgetBaseURI() {
		return widgetBaseURI;
	}

	public void setWidgetBaseURI(String widgetBaseURI) {
		this.widgetBaseURI = widgetBaseURI;
	}
	
}
