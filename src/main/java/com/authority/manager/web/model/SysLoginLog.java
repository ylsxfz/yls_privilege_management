package com.authority.manager.web.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="sys_login_log")
public class SysLoginLog extends BaseModel {

	@Column(name = "user_name")
    private String userName;

	@Column(name = "status")
    private String status;

	@Column(name = "ip")
    private String ip;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}


	@Override
	public String toString() {
		return "SysLoginLog{" +
				"userName='" + userName + '\'' +
				", status='" + status + '\'' +
				", ip='" + ip + '\'' +
				'}';
	}
}