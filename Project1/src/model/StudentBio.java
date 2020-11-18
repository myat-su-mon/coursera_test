package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "stu_bio")
public class StudentBio {
	@Id
	@Column(name = "sid")
	private String sid;
	@Column(name = "namee")
	private String namee;
	@Column(name = "phno")
	private String phno;
	@Column(name = "email")
	private String email;
	@Column(name = "namem")
	private String namem;
	@Column(name = "address")
	private String address;
	@Column(name = "blood")
	private String blood;
	@Column(name = "status")
	private String status;
	@Column(name = "regby")
	private String regby;
	@Column(name = "regdate")
	private String regdate;
	@Column(name = "entyear")
	private String entyear;
	@Column(name = "gender")
	private String gender;
	@Column(name = "nrcm")
	private String nrcm;
	@Column(name = "mmark")
	private String mmark;
	@Column(name = "fnamem")
	private String fnamem;
	@Column(name = "uid")
	private String uid;

	@OneToOne
	@JoinColumn(name = "nativetownship")
	private Township township;

	@OneToOne
	@JoinColumn(name = "stateregion")
	private StateRegion stateregion;

	@OneToOne
	@JoinColumn(name = "major")
	private SpecializedMajor major;

	public Township getTownship() {
		return township;
	}

	public void setTownship(Township township) {
		this.township = township;
	}

	public StateRegion getStateRegion() {
		return stateregion;
	}

	public void setStateRegion(StateRegion stateregion) {
		this.stateregion = stateregion;
	}

	public SpecializedMajor getMajor() {
		return major;
	}

	public void setSpMajor(SpecializedMajor major) {
		this.major = major;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getFnamem() {
		return fnamem;
	}

	public void setFnamem(String fnamem) {
		this.fnamem = fnamem;
	}

	public String getMmark() {
		return mmark;
	}

	public void setMmark(String mmark) {
		this.mmark = mmark;
	}

	public String getNrcm() {
		return nrcm;
	}

	public void setNrcm(String nrcm) {
		this.nrcm = nrcm;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getNamee() {
		return namee;
	}

	public void setNamee(String namee) {
		this.namee = namee;
	}

	public String getPhno() {
		return phno;
	}

	public void setPhno(String phno) {
		this.phno = phno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNamem() {
		return namem;
	}

	public void setNamem(String namem) {
		this.namem = namem;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBlood() {
		return blood;
	}

	public void setBlood(String blood) {
		this.blood = blood;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRegby() {
		return regby;
	}

	public void setRegby(String regby) {
		this.regby = regby;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getEntyear() {
		return entyear;
	}

	public void setEntyear(String entyear) {
		this.entyear = entyear;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}
