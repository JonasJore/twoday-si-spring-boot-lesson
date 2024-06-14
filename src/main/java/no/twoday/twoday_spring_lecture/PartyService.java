package no.twoday.twoday_spring_lecture;

import no.twoday.twoday_spring_lecture.dto.PokemonDTO;
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

  public void catchPokemon(String pokemonName) {
    var lowerCaseName = pokemonName.toLowerCase();
    String url = "https://pokeapi.co/api/v2/pokemon/" + lowerCaseName;
    PokemonDTO pokemonResponse = restTemplate.getForObject(url, PokemonDTO.class);

    if (pokemonResponse != null) {
      PokemonEntity entity = this.mapToPokemonEntity(pokemonResponse);
      pokemonRepository.save(entity);
      System.out.println("Catched " + pokemonResponse);
    }
  }

  public void releasePokemon(String id) {
    PokemonEntity pokemon = pokemonRepository.getById(Integer.parseInt(id));
    pokemonRepository.deleteById(Integer.parseInt(id));
    PokemonDTO releasedPokemon = this.mapToPokemonDto(pokemon);
    System.out.println("Released Pokemon " + releasedPokemon.getName());
  }

  public void releaseAllPokemon() {
    pokemonRepository.deleteAll();
    System.out.println("All Pokemon released");
  }

  private PokemonDTO mapToPokemonDto(PokemonEntity entity) {
    return new PokemonDTO(String.valueOf(entity.id), entity.name);
  }

  private PokemonEntity mapToPokemonEntity(PokemonDTO dto) {
    return new PokemonEntity(Integer.parseInt(dto.getId()), dto.getName());
  }
}
