package com.beerhouse.beer;

import com.beerhouse.beer.DTOs.BeerUpdateDTO;
import com.beerhouse.error.NotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BeerService {

  private BeerMapper beerMapper;
  private BeerRepository beerRepository;


  @Autowired
  public BeerService(BeerRepository beerRepository, BeerMapper beerMapper) {
    this.beerRepository = beerRepository;
    this.beerMapper = beerMapper;

  }

  public BeerModel saveBeer(BeerModel beerModel) {
    return beerRepository.save(beerModel);
  }

  public BeerModel getBeerById(Integer id) throws NotFoundException {
    return beerRepository.findById(id).orElseThrow(() -> new NotFoundException(
        "Desculpe, Cerveja não encontrada"));
  }

  public BeerModel putBeer(Integer id, BeerModel beerModelRequest) throws NotFoundException {
    beerModelRequest.setId(id);
    beerRepository.findById(id)
        .orElseThrow(() -> new NotFoundException(
            "Desculpe, Cerveja não encontrada"));
    return beerRepository.save(beerModelRequest);
  }

  public BeerModel patchBeer(Integer id, BeerUpdateDTO beerUpdateDTO) throws NotFoundException {

    BeerModel beerModel = beerRepository.findById(id)
        .orElseThrow(() -> new NotFoundException(
            "Sorry, item not found "));
    beerMapper.updateBeerFromDto(beerUpdateDTO, beerModel);
    return beerRepository.save(beerModel);

  }

  public void removeBeer(Integer id) throws NotFoundException {
    beerRepository.findById(id)
        .orElseThrow(() -> new NotFoundException(
            "Desculpe, Cerveja não encontrada"));
    beerRepository.delete(id);

  }

  public List<BeerModel> getBeers() {
    return beerRepository.findAll();
  }
}
