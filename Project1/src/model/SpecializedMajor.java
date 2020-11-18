package model;

import javax.persistence.*;

@Entity
@Table(name = "specializemajor")
public class SpecializedMajor {

	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "des")
	private String des;
	@Column(name = "longname")
	private String longname;
	@Column(name = "majorcreditlimit")
	private int majorcreditlimit;
	@Column(name = "electivecreditlimit")
	private int electivecreditlimit;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public String getLongName() {
		return longname;
	}

	public void setLongName(String longname) {
		this.longname = longname;
	}

	public int getMajorCreditLimit() {
		return majorcreditlimit;
	}

	public void setMajorCreditLimit(int majorcreditlimit) {
		this.majorcreditlimit = majorcreditlimit;
	}

	public int getElectiveCreditLimit() {
		return electivecreditlimit;
	}

	public void setElectiveCreditLimit(int electivecreditlimit) {
		this.electivecreditlimit = electivecreditlimit;
	}
}
