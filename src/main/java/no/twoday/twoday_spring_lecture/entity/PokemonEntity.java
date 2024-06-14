package no.twoday.twoday_spring_lecture.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class PokemonEntity {
  @Id
  public int id;
  public String name;

  public PokemonEntity(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public PokemonEntity() {

  }
}
