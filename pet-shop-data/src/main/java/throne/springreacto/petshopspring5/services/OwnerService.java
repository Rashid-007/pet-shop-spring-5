package throne.springreacto.petshopspring5.services;

import throne.springreacto.petshopspring5.model.Owner;

import java.util.Set;

public interface OwnerService {
    Owner findByLastName(String name);
    Owner findById(Long id);
    Owner save(Owner owner);

    Set<Owner> findAll();
}
