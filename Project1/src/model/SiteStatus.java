package model;

import javax.persistence.*;

@Entity
@Table(name = "sitestatus")
public class SiteStatus {

	@Id
	@Column(name = "id")
	private String id;

	@Column(name = "tvalue")
	private String tvalue;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTvalue() {
		return tvalue;
	}

	public void setTvalue(String tvalue) {
		this.tvalue = tvalue;
	}

}
