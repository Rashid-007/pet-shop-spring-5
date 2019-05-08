package throne.springreacto.petshopspring5.services;

import throne.springreacto.petshopspring5.model.Owner;

import java.util.Set;

public interface Vet {
    Vet findById(Long id);
    Vet save(Vet pet);

    Set<Vet> findAll();
}
