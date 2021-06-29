package ch.zhaw.springboot.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Indictment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String verdict;
	private String date;

	@ManyToOne
	private Defendant defendant;
	@ManyToOne
	private Crime crime;

	public Indictment(String verdict, String date, Defendant defendant, Crime crime) {
		this.verdict = verdict;
		this.date = date;
		this.defendant = defendant;
		this.crime = crime;
	}

	public Indictment() {
	}

	public long getId() {
		return id;
	}

	public String getVerdict() {
		return verdict;
	}

	public String getDate() {
		return date;
	}

	public Defendant getDefendant() {
		return defendant;
	}

	public Crime getCrime() {
		return crime;
	}

}
