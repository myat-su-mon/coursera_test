package model;

import javax.persistence.*;

@Entity
@Table(name = "keylist")
public class KeyList {
	@Id
	@Column(name = "uid")
	private String uid;
	@Column(name = "keyss")
	private String keyss;
	@Column(name = "bgcolor")
	private String bgcolor;
	@Column(name = "barcolor")
	private String barcolor;
	@Column(name = "ranks")
	private int ranks;

	public int getRanks() {
		return ranks;
	}

	public void setRanks(int ranks) {
		this.ranks = ranks;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getKeyss() {
		return keyss;
	}

	public void setKeyss(String keyss) {
		this.keyss = keyss;
	}

	public String getBgcolor() {
		return bgcolor;
	}

	public void setBgcolor(String bgcolor) {
		this.bgcolor = bgcolor;
	}

	public String getBarcolor() {
		return barcolor;
	}

	public void setBarcolor(String barcolor) {
		this.barcolor = barcolor;
	}
}
