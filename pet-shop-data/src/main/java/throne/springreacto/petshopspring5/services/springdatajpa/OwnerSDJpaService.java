package throne.springreacto.petshopspring5.services.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import throne.springreacto.petshopspring5.model.Owner;
import throne.springreacto.petshopspring5.repositories.OwnerRepository;
import throne.springreacto.petshopspring5.repositories.PetRepository;
import throne.springreacto.petshopspring5.repositories.PetTypeRepository;
import throne.springreacto.petshopspring5.services.OwnerService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service
@Profile("springdatajpa")
public class OwnerSDJpaService implements OwnerService {
    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;

    public OwnerSDJpaService(OwnerRepository ownerRepository, PetRepository petRepository,
                             PetTypeRepository petTypeRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Owner findByLastName(String lastname) {
        return ownerRepository.findByLastname(lastname);
    }

    @Override
    public List<Owner> findAllByLastnameLike(String lastName) {
        return ownerRepository.findAllByLastnameLike(lastName);
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public Owner findById(Long id) {
        return ownerRepository.findById(id).orElse(null);
    }

    @Override
    public Owner save(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public void delete(Owner owner) {
        ownerRepository.delete(owner);
    }

    @Override
    public void deleteById(Long id) {
        ownerRepository.deleteById(id);
    }
}
