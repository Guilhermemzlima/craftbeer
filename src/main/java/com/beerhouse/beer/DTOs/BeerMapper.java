package com.beerhouse.beer.DTOs;

import com.beerhouse.beer.BeerModel;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;


@Mapper(componentModel = "spring")
public interface BeerMapper {

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
  void updateBeerFromDto(BeerUpdateDTO dto, @MappingTarget BeerModel entity);
}
