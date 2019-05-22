package throne.springreacto.petshopspring5.repositories;

import org.springframework.data.repository.CrudRepository;
import throne.springreacto.petshopspring5.model.Owner;

import java.util.List;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
    Owner findByLastname(String lastname);
    List<Owner> findAllByLastnameLike(String lastName);
}
