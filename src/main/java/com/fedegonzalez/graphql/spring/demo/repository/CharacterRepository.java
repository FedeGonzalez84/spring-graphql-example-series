package com.fedegonzalez.graphql.spring.demo.repository;

import com.fedegonzalez.graphql.spring.demo.model.SeriesCharacter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CharacterRepository extends JpaRepository<SeriesCharacter, Integer> {
	
}
