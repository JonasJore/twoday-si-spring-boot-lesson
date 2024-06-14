package no.twoday.twoday_spring_lecture;

import no.twoday.twoday_spring_lecture.dto.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

  @Autowired
  private PokemonService pokemonService;

  @GetMapping("/{pokemonName}")
  public Pokemon getPokemon(@PathVariable String pokemonName) {
    return pokemonService.observePokemon(pokemonName);
  }
}
