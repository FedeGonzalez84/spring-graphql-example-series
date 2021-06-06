package com.fedegonzalez.graphql.spring.demo.resolver;

import java.util.List;

import com.fedegonzalez.graphql.spring.demo.model.Series;
import com.fedegonzalez.graphql.spring.demo.model.SeriesCharacter;
import com.fedegonzalez.graphql.spring.demo.service.SeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;


@Component
public class Query implements GraphQLQueryResolver {
	
	@Autowired
    private SeriesService service;

		
	public List<SeriesCharacter> characters() {
		return service.getCharacters();
	}
	
	public SeriesCharacter character(Integer id) {
		return service.getCharacter(id);
	}
	
	public List<Series> allSeries() {
		return service.getSeries();
	}
	
	public Series series(Integer id) {
		return service.getSeries(id);
	}	
	
}