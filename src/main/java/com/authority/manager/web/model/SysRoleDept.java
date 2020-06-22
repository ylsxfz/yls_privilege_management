package com.authority.manager.web.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="sys_role_dept")
public class SysRoleDept extends BaseModel {
	@Column(name = "role_id")
    private String roleId;

	@Column(name = "dept_id")
    private String deptId;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}


	@Override
	public String toString() {
		return "SysRoleDept{" +
				"roleId=" + roleId +
				", deptId=" + deptId +
				'}';
	}
}