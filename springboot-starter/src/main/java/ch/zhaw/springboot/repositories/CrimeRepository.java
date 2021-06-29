package ch.zhaw.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zhaw.springboot.entities.Crime;

public interface CrimeRepository extends JpaRepository<Crime, Long>  {

}
