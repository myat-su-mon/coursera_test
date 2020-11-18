package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reglist")
public class RegDate {

	@Column(name = "sid")
	private String sid;
	@Column(name = "acayr")
	private String acayr;
	@Column(name = "rdate")
	private String rdate;
	@Column(name = "adate")
	private String adate;
	@Column(name = "rdatetime")
	private String rdatetime;
	@Column(name = "adatetime")
	private String adatetime;
	@Column(name = "bank")
	private String bank;
	@Column(name = "tid")
	private String tid;
	@Column(name = "status")
	private int status;

	@Id

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getAcayr() {
		return acayr;
	}

	public void setAcayr(String acayr) {
		this.acayr = acayr;
	}

	public String getRdate() {
		return rdate;
	}

	public void setRdate(String rdate) {
		this.rdate = rdate;
	}

	public String getAdate() {
		return adate;
	}

	public void setAdate(String adate) {
		this.adate = adate;
	}

	public String getRdatetime() {
		return rdatetime;
	}

	public void setRdatetime(String rdatetime) {
		this.rdatetime = rdatetime;
	}

	public String getAdatetime() {
		return adatetime;
	}

	public void setAdatetime(String adatetime) {
		this.adatetime = adatetime;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
