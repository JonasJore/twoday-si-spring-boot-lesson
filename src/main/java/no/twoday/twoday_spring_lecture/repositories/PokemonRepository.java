package no.twoday.twoday_spring_lecture.repositories;

import no.twoday.twoday_spring_lecture.entity.PokemonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<PokemonEntity, Integer> {
}
