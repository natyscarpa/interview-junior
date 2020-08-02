package br.com.brainweb.interview.core.features.hero;

import java.util.Map;
import java.util.UUID;

import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.brainweb.interview.model.Hero;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
//@EnableJdbcRepositories
public class HeroRepository {
	
	public HeroRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		super();
		this.namedParameterJdbcTemplate = null;
	}

	private static final String CREATE_HERO_QUERY = "INSERT INTO hero" +
        " (name, race, power_stats_id)" +
        " VALUES (:name, :race, :powerStatsId) RETURNING id";

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    UUID create(Hero hero) {
        final Map<String, Object> params = Map.of("name", hero.getName(),
            "race", hero.getRace().name(),
            "powerStatsId", hero.getPowerStatsId());

        return null; /***namedParameterJdbcTemplate.queryForObject(
            CREATE_HERO_QUERY,
            params,
            UUID.class); */
    }	
}
