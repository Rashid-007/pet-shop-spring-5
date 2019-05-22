package throne.springreacto.petshopspring5.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import throne.springreacto.petshopspring5.model.Pet;
import throne.springreacto.petshopspring5.repositories.PetRepository;
import throne.springreacto.petshopspring5.services.PetService;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class PetServiceMapTest {

  private PetService sut;

  private final Long petId = 1L;

  @BeforeEach
  void setUp() {
    sut = new PetServiceMap();

    sut.save(Pet.builder().id(petId).build());
  }

  @Test
  void findAll() {
    Set<Pet> petSet = sut.findAll();

    assertEquals(1, petSet.size());
  }

  @Test
  void findByIdExistingId() {

    Pet pet = sut.findById(petId);

    assertEquals(petId, pet.getId());
  }

  @Test
  void findByIdNotExistingId() {

    Pet pet = sut.findById(5L);

    assertNull(pet);
  }

  @Test
  void findByIdNullId() {
    Pet pet = sut.findById(null);

    assertNull(pet);
  }


  @Test
  void saveExistingId() {

    //given
    Long id = 2L;

    Pet pet2 = Pet.builder().id(id).build();

    //when
    Pet savedPet = sut.save(pet2);

    //then
    assertEquals(id, savedPet.getId());
  }

  @Test
  void saveDuplicateId() {

    Long id = 1L;

    Pet pet2 = Pet.builder().id(id).build();

    Pet savedPet = sut.save(pet2);

    assertEquals(id, savedPet.getId());
    assertEquals(1, sut.findAll().size());
  }


  @Test
  void saveNoId() {

    Pet savedPet = sut.save(Pet.builder().build());

    assertNotNull(savedPet);
    assertNotNull(savedPet.getId());
    assertEquals(1, sut.findAll().size());
  }

  @Test
  void deletePet() {

    sut.delete(sut.findById(petId));

    assertEquals(0, sut.findAll().size());

  }


  @Test
  void deleteWithWrongId() {

    Pet pet = Pet.builder().id(5L).build();

    sut.delete(pet);

    assertEquals(1, sut.findAll().size());
  }

  @Test
  void deleteWithNullId() {

    Pet pet = Pet.builder().build();

    sut.delete(pet);

    assertEquals(1, sut.findAll().size());
  }

  @Test
  void deleteNull() {

    sut.delete(null);

    assertEquals(1, sut.findAll().size());

  }

  @Test
  void deleteByIdCorrectId() {

    sut.deleteById(petId);

    assertEquals(0, sut.findAll().size());
  }

  @Test
  void deleteByIdWrongId() {

    sut.deleteById(5L);

    assertEquals(1, sut.findAll().size());
  }

  @Test
  void deleteByIdNullId() {

    sut.deleteById(null);

    assertEquals(1, sut.findAll().size());
  }
}
