package model;

import javax.persistence.*;

@Entity
@Table(name = "loginlist")
public class LoginList {
	@Id
	@Column(name = "loginid")
	private String loginid;
	@Column(name = "uid")
	private String uid;
	@Column(name = "entdate")
	private String entdate;
	@Column(name = "enttime")
	private String enttime;
	@Column(name = "extdate")
	private String extdate;
	@Column(name = "exttime")
	private String exttime;

	public String getLoginid() {
		return loginid;
	}

	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getEntdate() {
		return entdate;
	}

	public void setEntdate(String entdate) {
		this.entdate = entdate;
	}

	public String getEnttime() {
		return enttime;
	}

	public void setEnttime(String enttime) {
		this.enttime = enttime;
	}

	public String getExtdate() {
		return extdate;
	}

	public void setExtdate(String extdate) {
		this.extdate = extdate;
	}

	public String getExttime() {
		return exttime;
	}

	public void setExttime(String exttime) {
		this.exttime = exttime;
	}

}
