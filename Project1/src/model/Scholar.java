package model;

import javax.persistence.*;

@Entity
@Table(name = "scholar")
public class Scholar {

	@Id
	@Column(name = "sid")
	private String sid;
	@Column(name = "entyear")
	private String entyear;
	@Column(name = "scholarname")
	private String scholarname;

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getEntYear() {
		return entyear;
	}

	public void setEntYear(String entyear) {
		this.entyear = entyear;
	}

	public String getScholarName() {
		return scholarname;
	}

	public void setScholarName(String scholarname) {
		this.scholarname = scholarname;
	}
}
