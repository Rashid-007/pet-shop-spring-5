package throne.springreacto.petshopspring5.repositories;

import org.springframework.data.repository.CrudRepository;
import throne.springreacto.petshopspring5.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
