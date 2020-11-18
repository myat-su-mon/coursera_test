package model;

import javax.persistence.*;

@Entity
@Table(name = "etype")
public class EType {

	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "etype")
	private String etype;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEtype() {
		return etype;
	}

	public void setEtype(String etype) {
		this.etype = etype;
	}

}