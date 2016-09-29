package com.hiyond.entity;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
	
	private static final long serialVersionUID = -906915044740809956L;

	private Integer id;
	
	private String name;
	
	private String password;

	private Date lastLoginTime;

	private String UUID;
	
	public String getUUID() {
        return UUID;
    }

    public void setUUID(String uUID) {
        UUID = uUID == null ? null : uUID.trim();
    }

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : StringUtils.isBlank(name) ? null : StringUtils.trim(name);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : StringUtils.isBlank(password) ? null : StringUtils.trim(password);
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", lastLoginTime=" + lastLoginTime
		        + "]";
	}

}
