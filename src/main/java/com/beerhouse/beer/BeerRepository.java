package com.beerhouse.beer;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeerRepository extends JpaRepository<BeerModel, Integer> {
  Optional<BeerModel> findById(Integer id);
}
