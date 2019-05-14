package throne.springreacto.petshopspring5.repositories;

import org.springframework.data.repository.CrudRepository;
import throne.springreacto.petshopspring5.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
