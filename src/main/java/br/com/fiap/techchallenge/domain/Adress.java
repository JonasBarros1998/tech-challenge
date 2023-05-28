package br.com.fiap.techchallenge.domain;

import jakarta.validation.constraints.NotEmpty;

public class Adress {
  
  @NotEmpty
  private final String street;

  @NotEmpty
  private final String number;

  @NotEmpty
  private final String neighborhood;

  @NotEmpty
  private final String city;

  @NotEmpty
  private final String state;
  
  public Adress(String street, String number, String neighborhood, String city, String state) {
    this.street = street;
    this.number = number;
    this.neighborhood = neighborhood;
    this.city = city;
    this.state = state;
  }

  public String getStreet() {
    return street;
  }

  public String getNumber() {
    return number;
  }

  public String getNeighborhood() {
    return neighborhood;
  }

  public String getCity() {
    return city;
  }

  public String getState() {
    return state;
  }
  
}
