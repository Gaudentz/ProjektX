package ch.zhaw.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zhaw.springboot.entities.Multiple;

public interface MultipleRepository extends JpaRepository<Multiple, Long>{
}
