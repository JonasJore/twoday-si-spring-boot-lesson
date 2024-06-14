package no.twoday.twoday_spring_lecture;

import no.twoday.twoday_spring_lecture.dto.Pokemon;
import no.twoday.twoday_spring_lecture.entity.PokemonEntity;
import no.twoday.twoday_spring_lecture.repositories.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PartyService {
  @Autowired
  RestTemplate restTemplate;
  @Autowired
  PokemonRepository pokemonRepository;

  void catchPokemon(String pokemonName) {
    var lowerCaseName = pokemonName.toLowerCase();
    String url = "https://pokeapi.co/api/v2/pokemon/" + lowerCaseName;
    Pokemon pokemonResponse = restTemplate.getForObject(url, Pokemon.class);

    if (pokemonResponse != null) {
      PokemonEntity entity = new PokemonEntity(Integer.parseInt(pokemonResponse.getId()), pokemonResponse.getName());
      pokemonRepository.save(entity);
      System.out.println("Catched " + pokemonResponse);
    }
  }
}
