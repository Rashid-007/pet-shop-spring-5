package throne.springreacto.petshopspring5.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import throne.springreacto.petshopspring5.model.Speciality;
import throne.springreacto.petshopspring5.model.Vet;
import throne.springreacto.petshopspring5.services.SpecialityService;
import throne.springreacto.petshopspring5.services.VetService;

import java.util.Set;
@Service
@Profile({"default", "map"})
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
    private final SpecialityService specialityService;

    public VetServiceMap(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet vet) {
        super.delete(vet);
    }

    @Override
    public Vet save(Vet vet) {
        if(vet.getSpecialities().size() > 0){
            vet.getSpecialities().forEach(speciality -> {
                if(speciality.getId() == null){
                    Speciality savedSpeciality = specialityService.save(speciality);
                    speciality.setId(savedSpeciality.getId());
                }
            });
        }
        return super.save(vet);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
