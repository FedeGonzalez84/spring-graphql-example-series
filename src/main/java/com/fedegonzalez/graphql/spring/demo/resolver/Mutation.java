package com.fedegonzalez.graphql.spring.demo.resolver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.fedegonzalez.graphql.spring.demo.model.Series;
import com.fedegonzalez.graphql.spring.demo.model.SeriesCharacter;
import com.fedegonzalez.graphql.spring.demo.service.SeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;


@Component
public class Mutation implements GraphQLMutationResolver {
    
	@Autowired
    private SeriesService service;
	
	
	public Series createSeries(String name, Integer nrOfSeasons) {
		return service.createSeries(name, nrOfSeasons);
	}
	
	public SeriesCharacter createCharacter(String name, String nickname, String occupation, String birthday, Integer seriesId) {
		LocalDate dayOfBirth = LocalDate.parse(birthday, DateTimeFormatter.ISO_DATE);  // date pattern example: '2011-12-03'
		return service.createCharacter(name, nickname, occupation, dayOfBirth, seriesId);
	}
	    
}