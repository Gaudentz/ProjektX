package ch.zhaw.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zhaw.springboot.entities.Single;

public interface SingleRepository extends JpaRepository<Single, Long>{

}
