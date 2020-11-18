package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "coresubject")
public class CoreSubject {

	@Id
	@Column(name = "subcode")
	private String subcode;

	@Column(name = "subname")
	private String subname;

	@OneToOne
	@JoinColumn(name = "subcategory")
	private CoreCategory subcategory;

	@Column(name = "semester")
	private int semester;

	@Column(name = "credit")
	private int credit;

	@Column(name = "prereq")
	private String prereq;

	@OneToOne
	@JoinColumn(name = "department")
	private Department department;

	@Column(name = "purpose")
	private String purpose;

	@Column(name = "status")
	private int status;

	@Column(name = "descrip")
	private String descrip;

	@Column(name = "outline")
	private String outline;

	@Column(name = "refbook")
	private String refbook;

	@Column(name = "ssno")
	private int ssno;

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

	public CoreCategory getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(CoreCategory subcategory) {
		this.subcategory = subcategory;
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

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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

	public int getSsno() {
		return ssno;
	}

	public void setSsno(int ssno) {
		this.ssno = ssno;
	}

	public int getSemesterlimit() {
		return semesterlimit;
	}

	public void setSemesterlimit(int semesterlimit) {
		this.semesterlimit = semesterlimit;
	}

}
