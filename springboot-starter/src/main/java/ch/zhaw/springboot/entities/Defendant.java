package ch.zhaw.springboot.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Defendant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;
	private String gender;
	private String race;

	public Defendant(String name, String gender, String race) {
		this.name = name;
		this.gender = gender;
		this.race = race;
	}

	public Defendant() {
	}

	public String getName() {
		return this.name;
	}

	public String getGender() {
		return this.gender;
	}

	public long getId() {
		return this.id;
	}

	public String getRace() {
		return race;
	}

}