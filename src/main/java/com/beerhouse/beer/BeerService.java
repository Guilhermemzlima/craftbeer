package com.beerhouse.beer;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BeerService {


  private BeerRepository beerRepository;

  @Autowired
  public BeerService(BeerRepository beerRepository) {
    this.beerRepository = beerRepository;
  }

  public BeerModel saveBeer(BeerModel beerModel) {
    return beerRepository.save(beerModel);
  }

  public BeerModel getBeerById(Integer id) {
    return beerRepository.findOne(id);
  }
}
