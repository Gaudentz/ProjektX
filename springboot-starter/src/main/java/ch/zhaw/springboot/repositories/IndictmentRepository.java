package ch.zhaw.springboot.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ch.zhaw.springboot.entities.Defendant;
import ch.zhaw.springboot.entities.Indictment;

public interface IndictmentRepository extends JpaRepository<Indictment, Long> {
	@Query("SELECT d FROM Defendant d, Indictment i WHERE i.date= ?1 AND d.id=i.defendant")
	public List<Defendant> getDefendantsByDateOfIndictment(String date);

}
