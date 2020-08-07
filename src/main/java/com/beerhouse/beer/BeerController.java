package com.beerhouse.beer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("beer")
public class BeerController {

  @Autowired
  private BeerRepository beerRepository;

  private BeerService beerService;
  @Autowired
  public BeerController(BeerService beerService) {
    this.beerService = beerService;
  }

  @GetMapping("/id")
  public ResponseEntity<BeerModel> getBeerById(@PathVariable Integer id){
    BeerModel beerModel = beerService.getBeerById(id);
    return ResponseEntity.ok(beerModel);
  }
  @PostMapping
  public BeerModel postBeer(@RequestBody BeerModel beerModel) {
    return beerService.saveBeer(beerModel);
  }

}
