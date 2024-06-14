package no.twoday.twoday_spring_lecture.dto;

public class PokemonDTO {
  private String id;
  private String name;

  public PokemonDTO(String id, String name) {
    this.id = id;
    this.name = name;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }
}
