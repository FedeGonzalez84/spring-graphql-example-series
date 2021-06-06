package com.fedegonzalez.graphql.spring.demo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


import com.fedegonzalez.graphql.spring.demo.model.Series;
import com.fedegonzalez.graphql.spring.demo.model.SeriesCharacter;
import com.fedegonzalez.graphql.spring.demo.repository.CharacterRepository;
import com.fedegonzalez.graphql.spring.demo.repository.SeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class SeriesService {

	@Autowired
	private CharacterRepository characterRepository;
	
	@Autowired
	private SeriesRepository seriesRepository;
	
	
	@Transactional
	public Series createSeries(String name, Integer nrOfSeasons) {
		Series series = new Series(name, nrOfSeasons);
		return seriesRepository.save(series);
	}
	
	@Transactional(readOnly = true)
	public List<Series> getSeries() {
		return seriesRepository.findAll();
	}
	
	@Transactional(readOnly = true)
	public Series getSeries(Integer id) {
		Optional<Series> series = seriesRepository.findById(id);
        return series.orElseThrow(() -> new IllegalArgumentException("Series 'id' not found!!!")  );
	}
	
	@Transactional
	public SeriesCharacter createCharacter(String name, String nickname, String occupation, LocalDate dateofbirth, Integer seriesId) {
		SeriesCharacter character = new SeriesCharacter(name, nickname, occupation, dateofbirth);
		Series series = getSeries(seriesId);
        character.setSeries(series);
        return characterRepository.save(character);
	}
	
	@Transactional(readOnly = true)
	public List<SeriesCharacter> getCharacters() {
		return characterRepository.findAll();
	}
	
	@Transactional(readOnly = true)
	public SeriesCharacter getCharacter(Integer id) {
		Optional<SeriesCharacter> characterOpt = characterRepository.findById(id);
		return characterOpt.orElseThrow(() -> new IllegalArgumentException("Character 'id' not found!!!"));
	}

}
