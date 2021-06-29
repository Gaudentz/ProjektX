package ch.zhaw.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zhaw.springboot.entities.Defendant;

public interface DefendantRepository extends JpaRepository<Defendant, Long>{
	
	/*
	
	@Query("SELECT n,d FROM Defendant de, Indictment i WHERE de.id = i.defendant_id AND i.d = '?1' ")
	public List<Defendant> getDefendantsByDateOfIndictment(String date);
*/

}
