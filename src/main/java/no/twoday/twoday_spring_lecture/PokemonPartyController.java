package no.twoday.twoday_spring_lecture;

import no.twoday.twoday_spring_lecture.dto.PokemonDTO;
import no.twoday.twoday_spring_lecture.repositories.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/party")
public class PokemonPartyController {
  @Autowired
  PokemonRepository pokemonRepository;
  @Autowired
  PartyService partyService;

  @PostMapping("/{pokemonName}")
  public void catchPokemon(@PathVariable String pokemonName) {
    partyService.catchPokemon(pokemonName);
  }

  @GetMapping("/all")
  List<PokemonDTO> getAllPromParty() {
    return pokemonRepository.findAll().stream()
        .map((pokemon) -> new PokemonDTO(String.valueOf(pokemon.id), pokemon.name)).collect(Collectors.toList());
  }

  @DeleteMapping("/release/{id}")
  void releasePokemon(@PathVariable String id) {
    partyService.releasePokemon(id);
  }

  @DeleteMapping("/release/all")
  void releaseAll() {
    partyService.releaseAllPokemon();
  }
}
