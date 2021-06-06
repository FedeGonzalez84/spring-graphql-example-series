package com.fedegonzalez.graphql.spring.demo.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.fedegonzalez.graphql.spring.demo.model.Series;
import com.fedegonzalez.graphql.spring.demo.model.SeriesCharacter;
import com.fedegonzalez.graphql.spring.demo.service.SeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class SeriesCharacterResolver implements GraphQLResolver<SeriesCharacter> {
	
	@Autowired
    private SeriesService seriesService;

    public Series getSeries(SeriesCharacter character) {
    	return seriesService.getSeries(character.getSeries().getId());
    }
        
}
