package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "timetable")
public class TimeTable {
	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "dayy")
	private int dayy;

	@Column(name = "perio")
	private int perio;

	@Column(name = "fro")
	private String fro;

	@Column(name = "too")
	private String too;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDayy() {
		return dayy;
	}

	public void setDayy(int dayy) {
		this.dayy = dayy;
	}

	public int getPerio() {
		return perio;
	}

	public void setPerio(int perio) {
		this.perio = perio;
	}

	public String getFro() {
		return fro;
	}

	public void setFro(String fro) {
		this.fro = fro;
	}

	public String getToo() {
		return too;
	}

	public void setToo(String too) {
		this.too = too;
	}

}