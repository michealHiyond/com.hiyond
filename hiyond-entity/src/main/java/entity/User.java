package entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
	
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
        UUID = uUID;
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
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
