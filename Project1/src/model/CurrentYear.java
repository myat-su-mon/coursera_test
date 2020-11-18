package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "currentyear")
public class CurrentYear {
	private int id;
	private int curYr;
	private int curSem;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "curYr")
	public int getcurYr() {
		return curYr;
	}

	public void setcurYr(int curYr) {
		this.curYr = curYr;
	}

	@Column(name = "curSem")
	public int getcurSem() {
		return curSem;
	}

	public void setcurSem(int curSem) {
		this.curSem = curSem;
	}
}
