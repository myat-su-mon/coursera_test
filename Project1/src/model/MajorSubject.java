package model;

import javax.persistence.*;

@Entity
@Table(name = "majorsubject")
public class MajorSubject {
	@Id
	@Column(name = "subcode")
	private String subcode;

	@Column(name = "subname")
	private String subname;

	@Column(name = "semester")
	private int semester;

	@Column(name = "credit")
	private int credit;

	@Column(name = "prereq")
	private String prereq;

	@OneToOne
	@JoinColumn(name = "department")
	private Department department;

	@Column(name = "status")
	private int status;

	@Column(name = "purpose")
	private String purpose;

	@Column(name = "descrip")
	private String descrip;

	@Column(name = "outline")
	private String outline;

	@Column(name = "refbook")
	private String refbook;

	@Column(name = "bis")
	private int bis;

	@Column(name = "csf")
	private int csf;

	@Column(name = "ke")
	private int ke;

	@Column(name = "se")
	private int se;

	@Column(name = "nt")
	private int nt;

	@Column(name = "emb")
	private int emb;

	@Column(name = "semesterlimit")
	private int semesterlimit;

	public String getSubcode() {
		return subcode;
	}

	public void setSubcode(String subcode) {
		this.subcode = subcode;
	}

	public String getSubname() {
		return subname;
	}

	public void setSubname(String subname) {
		this.subname = subname;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public String getPrereq() {
		return prereq;
	}

	public void setPrereq(String prereq) {
		this.prereq = prereq;
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

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getDescrip() {
		return descrip;
	}

	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}

	public String getOutline() {
		return outline;
	}

	public void setOutline(String outline) {
		this.outline = outline;
	}

	public String getRefbook() {
		return refbook;
	}

	public void setRefbook(String refbook) {
		this.refbook = refbook;
	}

	public int getBis() {
		return bis;
	}

	public void setBis(int bis) {
		this.bis = bis;
	}

	public int getCsf() {
		return csf;
	}

	public void setCsf(int csf) {
		this.csf = csf;
	}

	public int getKe() {
		return ke;
	}

	public void setKe(int ke) {
		this.ke = ke;
	}

	public int getSe() {
		return se;
	}

	public void setSe(int se) {
		this.se = se;
	}

	public int getNt() {
		return nt;
	}

	public void setNt(int nt) {
		this.nt = nt;
	}

	public int getEmb() {
		return emb;
	}

	public void setEmb(int emb) {
		this.emb = emb;
	}

	public int getSemesterlimit() {
		return semesterlimit;
	}

	public void setSemesterlimit(int semesterlimit) {
		this.semesterlimit = semesterlimit;
	}

}