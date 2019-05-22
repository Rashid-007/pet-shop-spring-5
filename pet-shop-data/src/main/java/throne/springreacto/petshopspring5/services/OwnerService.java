package throne.springreacto.petshopspring5.services;

import throne.springreacto.petshopspring5.model.Owner;

import java.util.List;

public interface OwnerService extends CrudService<Owner, Long>{
    Owner findByLastName(String name);
    List<Owner> findAllByLastnameLike(String lastName);
}
