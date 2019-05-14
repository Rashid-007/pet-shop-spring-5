package throne.springreacto.petshopspring5.repositories;

import org.springframework.data.repository.CrudRepository;
import throne.springreacto.petshopspring5.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
    Owner findByLastname(String lastname);
}
