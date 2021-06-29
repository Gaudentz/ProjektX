package ch.zhaw.springboot.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Crime {
	

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String description;
	private String category;
	private String sentencing;

	public Crime(String description, String category, String sentencing) {
		this.description = description;
		this.category = category;
		this.sentencing = sentencing;

	}
	//GETTER methoden
	
	public Crime() {
	}

	public long getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public String getCategroy() {
		return category;
	}

	public String getSentencing() {
		return sentencing;
	}
	

}
