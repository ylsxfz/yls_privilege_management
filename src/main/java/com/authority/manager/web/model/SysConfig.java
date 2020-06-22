package com.authority.manager.web.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="sys_config")
public class SysConfig extends BaseModel {

	@Column(name = "value")
    private String value;
	@Column(name = "label")
    private String label;
	@Column(name = "type")
    private String type;
	@Column(name = "description")
    private String description;
	@Column(name = "sort")
    private Long sort;
	@Column(name = "remarks")
    private String remarks;
	@Column(name = "del_flag")
    private Byte delFlag;


	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getSort() {
		return sort;
	}

	public void setSort(Long sort) {
		this.sort = sort;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Byte getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Byte delFlag) {
		this.delFlag = delFlag;
	}

	@Override
	public String toString() {
		return "SysConfig{" +
				"value='" + value + '\'' +
				", label='" + label + '\'' +
				", type='" + type + '\'' +
				", description='" + description + '\'' +
				", sort=" + sort +
				", remarks='" + remarks + '\'' +
				", delFlag=" + delFlag +
				'}';
	}
}