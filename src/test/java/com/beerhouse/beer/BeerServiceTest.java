package com.beerhouse.beer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.beerhouse.beer.DTOs.BeerMapper;
import com.beerhouse.beer.DTOs.BeerUpdateDTO;
import com.beerhouse.error.NotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = BeerService.class)
public class BeerServiceTest {

  //private static final String NAME = "Nome cadastrado pelo JUnit";

  @InjectMocks
  private BeerService beerService;
  @Mock
  private BeerMapper beerMapper;
  @Mock
  private BeerRepository beerRepository;

  @Before
  public void setUp() {
    beerRepository = Mockito.mock(BeerRepository.class);
    beerMapper = Mockito.mock(BeerMapper.class);
    beerService = new BeerService(beerRepository, beerMapper);

  }

  public BeerModel getBeerModel() {
    BeerModel beerModel = new BeerModel();
    beerModel.setName("nome teste");
    beerModel.setIngredients("ingredientes teste");
    beerModel.setCategory("cagoria Teste");
    beerModel.setAlcoholContent("10%");
    beerModel.setPrice(15.0);
    return beerModel;
  }

  @Test
  public void saveBeer() {
    BeerModel beerModel = getBeerModel();
    when(beerRepository.save(beerModel)).thenReturn(beerModel);
    BeerModel beerModel1 = beerService.saveBeer(beerModel);
    verify(beerRepository).save(beerModel);
    assertEquals(beerModel.getName(), beerModel1.getName());
  }

  @Test
  public void getBeerById() throws NotFoundException {
    BeerModel beerModel = getBeerModel();
    beerModel.setId(3);
    when(beerRepository.findById(3)).thenReturn(java.util.Optional.of(beerModel));
    BeerModel beerModel1 = beerService.getBeerById(3);
    assertEquals(beerModel.getId(), beerModel1.getId());
  }

  @Test
  public void putBeer() throws NotFoundException {
    BeerModel beerModel = getBeerModel();
    beerModel.setId(3);
    when(beerRepository.findById(3)).thenReturn(java.util.Optional.of(beerModel));
    when(beerRepository.save(beerModel)).thenReturn(beerModel);
    BeerModel beerModel1 = beerService.putBeer(3, beerModel);
    assertEquals(beerModel.getId(), beerModel1.getId());
  }

  @Test
  public void putBeerError() throws NotFoundException {
    BeerModel beerModel = getBeerModel();
    beerModel.setId(3);
    when(beerRepository.findById(3)).thenReturn(java.util.Optional.empty());
    when(beerRepository.save(beerModel)).thenReturn(beerModel);
    try {
      BeerModel beerModel1 = beerService.putBeer(3, beerModel);
    } catch (NotFoundException e) {
      assertEquals(e.getCode().intValue(), 404);
      assertEquals(e.getMessages(), "Desculpe, Cerveja não encontrada");
    } catch (Exception e) {
      fail("not expected error");
    }
  }

  @Test
  public void patchBeer() throws NotFoundException {
    BeerModel beerModel = getBeerModel();
    beerModel.setId(3);
    BeerUpdateDTO beerUpdateDTO = new BeerUpdateDTO();
    beerUpdateDTO.setIngredients("ingrediente atualizado");
    when(beerRepository.findById(3)).thenReturn(java.util.Optional.of(beerModel));
    beerModel.setIngredients(beerUpdateDTO.getIngredients());
    when(beerRepository.save(beerModel)).thenReturn(beerModel);
    BeerModel beerModel1 = beerService.patchBeer(3, beerUpdateDTO);
    assertEquals(beerModel1.getIngredients(), beerUpdateDTO.getIngredients());
  }

  @Test
  public void removeBeer() throws NotFoundException {
    BeerModel beerModel = getBeerModel();
    beerModel.setId(3);
    when(beerRepository.findById(3)).thenReturn(java.util.Optional.of(beerModel));
    doNothing().when(beerRepository).delete(3);
    beerService.removeBeer(3);
  }

  @Test
  public void getBeers() {
    BeerModel beerModel = getBeerModel();
    List<BeerModel> beerList = new ArrayList<BeerModel>();
    beerList.add(beerModel);
    when(beerRepository.findAll()).thenReturn(beerList);
    List<BeerModel> beerList1 = beerService.getBeers();
    assertEquals(beerList1, beerList);
  }
}