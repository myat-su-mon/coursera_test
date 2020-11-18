package model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class Users {

	@Id
	@Column(name = "uid")
	private String uid;
	@Column(name = "uname")
	private String uname;
	@Column(name = "status")
	private int status;
	@Column(name = "webpage")
	private String webpage;

	@OneToOne
	@JoinColumn(name = "ranks")
	private Ranks ranks;

	@OneToOne
	@JoinColumn(name = "department")
	private Department department;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public Ranks getRanks() {
		return ranks;
	}

	public void setRanks(Ranks ranks) {
		this.ranks = ranks;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getWebpage() {
		return webpage;
	}

	public void setWebpage(String webpage) {
		this.webpage = webpage;
	}

}
