package ch.zhaw.springboot.entities;

import javax.persistence.Entity;

@Entity
public class Single extends Crime {

	private String nameVictim;

	public Single(String description, String category, String sentencing, String nameVictim) {
		super(description, category, sentencing);
		this.nameVictim = nameVictim;
	}

	public Single() {
	}

	public String getNameVictim() {
		return nameVictim;
	}

}
