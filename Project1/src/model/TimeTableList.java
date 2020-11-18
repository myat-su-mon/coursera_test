package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "timetablelist")
public class TimeTableList {

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "subcode")
	private String subcode;

	@Column(name = "room")
	private int room;

	@Column(name = "acayr")
	private String acayr;

	@Column(name = "day")
	private int day;

	@Column(name = "perio")
	private int perio;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubcode() {
		return subcode;
	}

	public void setSubcode(String subcode) {
		this.subcode = subcode;
	}

	public int getRoom() {
		return room;
	}

	public void setRoom(int room) {
		this.room = room;
	}

	public String getAcayr() {
		return acayr;
	}

	public void setAcayr(String acayr) {
		this.acayr = acayr;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getPerio() {
		return perio;
	}

	public void setPerio(int perio) {
		this.perio = perio;
	}
}
