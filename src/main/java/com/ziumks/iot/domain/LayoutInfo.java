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
@Table(name="layout_info", schema = "iot_web")
public class LayoutInfo implements Serializable{

	private static final long serialVersionUID = -5586956219931354345L;

	@Id
	@Column(name="layout_id", length=32)
	private String layoutId;
	
	@Column(name="layout_nm", length=300)
	private String layoutNm;
	
	@Column(name="layout_data", columnDefinition="text")
	private String layoutData;
	
	@Column(name="default_yn", length=1)
	private String defaultYn;
	
	@Column(name="cremn", length=32 )
	private String creMn;
	
	@Column(name="cre_dtm", length=32 )
	private String creDtm;
	
	@Column(name="updmn", length=32 )
	private String updMn;
	
	@Column(name="upd_dtm", length=32 )
	private String updDtm;
	
	@OneToMany(mappedBy = "layoutInfo", cascade = CascadeType.REMOVE, fetch=FetchType.EAGER)
	private List<WidgetInfo> widgetInfos;

	@Column(name="user_id", length=32 )
	private String userId;

	
	public String getLayoutNm() {
		return layoutNm;
	}

	public void setLayoutNm(String layoutNm) {
		this.layoutNm = layoutNm;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public List<WidgetInfo> getWidgetInfos() {
		return widgetInfos;
	}

	public void setWidgetInfos(List<WidgetInfo> widgetInfos) {
		this.widgetInfos = widgetInfos;
	}

	public String getLayoutId() {
		return layoutId;
	}

	public void setLayoutId(String layoutId) {
		this.layoutId = layoutId;
	}

	public String getLayoutData() {
		return layoutData;
	}

	public void setLayoutData(String layoutData) {
		this.layoutData = layoutData;
	}

	public String getDefaultYn() {
		return defaultYn;
	}

	public void setDefaultYn(String defaultYn) {
		this.defaultYn = defaultYn;
	}
	
}
