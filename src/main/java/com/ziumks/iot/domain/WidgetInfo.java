package com.ziumks.iot.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="widget_info", schema = "iot_web")
public class WidgetInfo implements Serializable {

	private static final long serialVersionUID = -474121303069358669L;

	@Id
	@Column(name="widget_id", length=32)
	private String widgetId;
	
	@Id
	@Column(name="layout_id", length=32)
	private String layoutId;
	
	@Column(name="widget_URI", length=500)
	private String widgetURI;
	
	@Column(name="title", length=500)
	private String title;
	
	@Column(name="type", length=50)
	private String type;
	
	@Column(name="positionInfo", length=500)
	private PositionInfo positionInfo;
	
	@Column(name="sizeInfo", length=500)
	private SizeInfo sizeInfo;
	
	@Column(name="parameter", columnDefinition="text")
	private String parameter;
	
	@Column(name="cremn", length=32 )
	private String creMn;
	
	@Column(name="cre_dtm", length=32 )
	private String creDtm;
	
	@Column(name="updmn", length=32 )
	private String updMn;
	
	@Column(name="upd_dtm", length=32 )
	private String updDtm;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "layout_id", referencedColumnName = "layout_id", insertable = false, updatable = false)
    private LayoutInfo layoutInfo;

	
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

	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public SizeInfo getSizeInfo() {
		return sizeInfo;
	}

	public void setSizeInfo(SizeInfo sizeInfo) {
		this.sizeInfo = sizeInfo;
	}

	public PositionInfo getPositionInfo() {
		return positionInfo;
	}

	public void setPositionInfo(PositionInfo positionInfo) {
		this.positionInfo = positionInfo;
	}


	public String getWidgetId() {
		return widgetId;
	}

	public void setWidgetId(String widgetId) {
		this.widgetId = widgetId;
	}

	public String getLayoutId() {
		return layoutId;
	}

	public void setLayoutId(String layoutId) {
		this.layoutId = layoutId;
	}

	public String getWidgetURI() {
		return widgetURI;
	}

	public void setWidgetURI(String widgetURI) {
		this.widgetURI = widgetURI;
	}

	public LayoutInfo getLayoutInfo() {
		return layoutInfo;
	}

	public void setLayoutInfo(LayoutInfo layoutInfo) {
		this.layoutInfo = layoutInfo;
	}
    
    
    
}
