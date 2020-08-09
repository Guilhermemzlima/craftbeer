package com.beerhouse.beer.DTOs;

import org.hibernate.validator.constraints.Length;

public class BeerUpdateDTO {
  private String name;
  private String ingredients;
  @Length(max = 20)
  private String alcoholContent;
  private Double price;
  @Length(max = 60)
  private String category;

  public BeerUpdateDTO(String name, String ingredients, String alcoholContent, Double price,
      String category) {
    this.name = name;
    this.ingredients = ingredients;
    this.alcoholContent = alcoholContent;
    this.price = price;
    this.category = category;
  }

  public BeerUpdateDTO() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getIngredients() {
    return ingredients;
  }

  public void setIngredients(String ingredients) {
    this.ingredients = ingredients;
  }

  public String getAlcoholContent() {
    return alcoholContent;
  }

  public void setAlcoholContent(String alcoholContent) {
    this.alcoholContent = alcoholContent;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }
}
