package com.fedegonzalez.graphql.spring.demo.repository;

import com.fedegonzalez.graphql.spring.demo.model.Series;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SeriesRepository extends JpaRepository<Series, Integer> {

}
