package throne.springreacto.petshopspring5.services;

import throne.springreacto.petshopspring5.model.Owner;
import throne.springreacto.petshopspring5.model.Pet;

import java.util.Set;

public interface PetService {
    Pet findById(Long id);
    Pet save(Pet pet);

    Set<Pet> findAll();
}
