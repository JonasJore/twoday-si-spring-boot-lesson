package no.twoday.twoday_spring_lecture;

import no.twoday.twoday_spring_lecture.dto.Pokemon;
import no.twoday.twoday_spring_lecture.repositories.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PokemonService {
  @Autowired
  private RestTemplate resttemplate;
  @Autowired
  private PokemonRepository pokemonRepository;

  Pokemon observePokemon(String pokemonName) {
    var lowerCaseName = pokemonName.toLowerCase();
    String url = "https://pokeapi.co/api/v2/pokemon/" + lowerCaseName;
    return resttemplate.getForObject(url, Pokemon.class);
  }
}
