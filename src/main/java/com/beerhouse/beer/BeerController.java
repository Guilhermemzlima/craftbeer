package com.beerhouse.beer;

import com.beerhouse.beer.DTOs.BeerUpdateDTO;
import com.beerhouse.error.NotFoundException;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("beer")
public class BeerController {


  private final BeerService beerService;

  @Autowired
  public BeerController(BeerService beerService) {
    this.beerService = beerService;
  }

  @GetMapping("/{id}")
  public ResponseEntity<BeerModel> getBeerById(@Valid @PathVariable Integer id)
      throws NotFoundException {
    return ResponseEntity.ok(beerService.getBeerById(id));
  }

  @GetMapping
  public ResponseEntity<List<BeerModel>> getBeers() {
    return ResponseEntity.ok(beerService.getBeers());
  }

  @PostMapping
  public ResponseEntity<BeerModel> postBeer(@Valid @RequestBody BeerModel beerModel)
      throws Exception {
    return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(beerService.saveBeer(beerModel));
  }

  @PutMapping("/{id}")
  public ResponseEntity<BeerModel> putBeer(@PathVariable Integer id,
      @Valid @RequestBody BeerModel beerModel) throws NotFoundException {
    return ResponseEntity.ok(beerService.putBeer(id, beerModel));
  }

  @PatchMapping("/{id}")
  public ResponseEntity<BeerModel> patchBeer(@PathVariable Integer id,
      @Valid @RequestBody BeerUpdateDTO beerUpdateDTO) throws NotFoundException {
    return ResponseEntity.ok(beerService.patchBeer(id, beerUpdateDTO));
  }


  @DeleteMapping("/{id}")
  public ResponseEntity<?> removeBeer(@PathVariable Integer id) throws NotFoundException {
    beerService.removeBeer(id);
    return ResponseEntity.noContent().build();
  }
}
