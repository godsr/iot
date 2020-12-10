package com.ziumks.iot.domain;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tag_model_mapp_info", schema = "iot_web")
public class TagModelMappInfo implements Serializable {

	private static final long serialVersionUID = 2093833831093447463L;

	@Id
	@Column(name="dvc_model_id", length=32 )
	private String dvcModelId;
	
	@Id
	@Column(name="tag_id", length=32 )
	private String tagId;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="dvc_model_id", updatable = false, insertable = false)
	private DvcModelInfo dvcModelInfo;
	
	/*@JsonIgnore*/
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="tag_id", updatable = false, insertable = false)
	private TagInfo tagInfo;
	
	
	public DvcModelInfo getDvcModelInfo() {
		return dvcModelInfo;
	}

	public void setDvcModelInfo(DvcModelInfo dvcModelInfo) {
		this.dvcModelInfo = dvcModelInfo;
	}

	public TagInfo getTagInfo() {
		return tagInfo;
	}

	public void setTagInfo(TagInfo tagInfo) {
		this.tagInfo = tagInfo;
	}

	public String getDvcModelId() {
		return dvcModelId;
	}

	public void setDvcModelId(String dvcModelId) {
		this.dvcModelId = dvcModelId;
	}

	public String getTagId() {
		return tagId;
	}

	public void setTagId(String tagId) {
		this.tagId = tagId;
	}
}
