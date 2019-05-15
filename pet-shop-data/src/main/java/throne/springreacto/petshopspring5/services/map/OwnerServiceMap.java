package throne.springreacto.petshopspring5.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import throne.springreacto.petshopspring5.model.Owner;
import throne.springreacto.petshopspring5.model.Pet;
import throne.springreacto.petshopspring5.services.OwnerService;
import throne.springreacto.petshopspring5.services.PetService;
import throne.springreacto.petshopspring5.services.PetTypeService;

import java.util.Set;
@Service
@Profile({"default", "map"})
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {
    private final PetService petService;
    private final PetTypeService petTypeService;

    public OwnerServiceMap(PetService petService, PetTypeService petTypeService) {
        this.petService = petService;
        this.petTypeService = petTypeService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner owner) {
        super.delete(owner);
    }

    @Override
    public Owner save(Owner owner) {
        if(owner != null){
            if(owner.getPets() != null){
                owner.getPets().forEach(pet -> {
                    if(pet.getPetType() != null){
                        if(pet.getPetType().getId() == null){
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    }else {
                        throw new RuntimeException("Pet type is required");
                    }

                    if(pet.getId() == null){
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());

                    }
                });
            }
            return super.save(owner);
        }else {
            return null;
        }
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findByLastName(String lastname) {
        return this.findAll().stream().filter(owner -> owner.getLastname().equalsIgnoreCase(lastname))
                .findFirst().orElse(null);
    }
}
