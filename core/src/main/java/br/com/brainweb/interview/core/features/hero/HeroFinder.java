package br.com.brainweb.interview.core.features.hero;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import br.com.brainweb.interview.model.Hero;

public interface HeroFinder extends CrudRepository<Hero, UUID> {

	List<Hero> findHeroByName(String name);

	Hero findHeroById(UUID id);
	
}

