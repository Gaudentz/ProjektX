package ch.zhaw.springboot.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Multiple extends Crime {

	@OneToMany
	private List<Crime> crimes;

	private String location;

	public Multiple(String description, String category, String sentencing, String location) {
		super(description, category, sentencing);
		this.location = location;
		this.crimes = new ArrayList<Crime>();
	}
	
	
	public List<Crime> getCrime() {
		return crimes;
	}
	
	public void addChild(Crime crimes) {
		if (!this.crimes.contains(crimes)) {
			this.crimes.add(crimes);
		}
	}
	//GETTER methoden
	
	public String getLocation() {
		return location;
	}

	public Multiple() {
	}

}
