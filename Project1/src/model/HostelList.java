package model;

import javax.persistence.*;

@Entity
@Table(name = "hostellist")
public class HostelList {

	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "des")
	private String des;

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
}
