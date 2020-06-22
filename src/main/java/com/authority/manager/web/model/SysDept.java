package com.authority.manager.web.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="sys_dept")
public class SysDept extends BaseModel {

	@Column(name = "name")
    private String name;

	@Column(name = "parent_id")
    private String parentId;

	@Column(name = "order_num")
    private Integer orderNum;

	@Column(name = "del_flag")
    private Byte delFlag;

    // 非数据库字段
	@Transient
	private List<SysDept> children;
    // 非数据库字段
	@Transient
	private String parentName;
    // 非数据库字段
	@Transient
	private Integer level;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public Integer getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}
	public Byte getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(Byte delFlag) {
		this.delFlag = delFlag;
	}
	public List<SysDept> getChildren() {
		return children;
	}
	public void setChildren(List<SysDept> children) {
		this.children = children;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "SysDept{" +
				"name='" + name + '\'' +
				", parentId=" + parentId +
				", orderNum=" + orderNum +
				", delFlag=" + delFlag +
				", children=" + children +
				", parentName='" + parentName + '\'' +
				", level=" + level +
				'}';
	}
}