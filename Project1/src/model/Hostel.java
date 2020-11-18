package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "hostel")
public class Hostel {

	@Id
	@Column(name = "sid")
	private String sid;
	@Column(name = "entyear")
	private String entyear;
	@OneToOne
	@JoinColumn(name = "hostelname")
	private HostelList hostellist;

	public HostelList getHostel() {
		return hostellist;
	}

	public void setHostel(HostelList hostellist) {
		this.hostellist = hostellist;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getEntyear() {
		return entyear;
	}

	public void setEntyear(String entyear) {
		this.entyear = entyear;
	}
}
