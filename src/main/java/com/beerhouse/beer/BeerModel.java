package com.beerhouse.beer;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
public class BeerModel implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @NotNull
  @NotEmpty
  private String name;
  @NotNull
  @NotEmpty
  private String ingredients;
  @NotNull
  @NotEmpty
  @Length(max = 20)
  private String alcoholContent;
  private Number price;
  @NotNull
  @NotEmpty
  @Length(max = 60)
  private String category;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
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

  public Number getPrice() {
    return price;
  }

  public void setPrice(Number price) {
    this.price = price;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }
}
