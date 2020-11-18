package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "corecategory")
public class CoreCategory {

	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "des")
	private String des;
	@Column(name = "reqcredit")
	private int reqcredit;

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

	public int getReqcredit() {
		return reqcredit;
	}

	public void setReqcredit(int reqcredit) {
		this.reqcredit = reqcredit;
	}

}
