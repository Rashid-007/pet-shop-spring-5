package throne.springreacto.petshopspring5.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import throne.springreacto.petshopspring5.model.*;
import throne.springreacto.petshopspring5.services.*;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final VetService vetService;
    private final OwnerService ownerService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(VetService vetService, OwnerService ownerService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {
        this.vetService = vetService;
        this.ownerService = ownerService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    private void loadData(){
        PetType dog = PetType.builder().name("Dog").build();
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = PetType.builder().name("Cat").build();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = Speciality.builder().description("Radiology").build();
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = Speciality.builder().description("Surgery").build();
        Speciality savedSurgery = specialityService.save(surgery);

        //peciality dentistry = new Speciality();
        //dentistry.setDescription("dentistry");
        //Speciality savedDentistry = specialtyService.save(dentistry);

        Owner owner1 = Owner.builder().id(1L).firstname("Michael").lastname("Weston").address("Westfriedhof")
                .city("Munich").telephone("123").build();

        Pet mikePet = Pet.builder().petType(savedDogPetType).owner(owner1).birthDate(LocalDate.now())
                .name("dagoo").build();
        owner1.getPets().add(mikePet);

        ownerService.save(owner1);

        Owner owner2 = Owner.builder().id(2L).firstname("Fiona").lastname("Glenanne").address("Westfriedhof")
                .city("Munich").telephone("123").build();

        Pet fionasCat = Pet.builder().petType(savedCatPetType).owner(owner2).name("catoo").birthDate(LocalDate.now())
                .build();
        owner2.getPets().add(fionasCat);

        ownerService.save(owner2);

        Visit catVisit = Visit.builder().date(LocalDate.now()).description("Injured Kitty").build();
        //catVisit.setPet(fionasCat);
        fionasCat.getVisits().add(catVisit);
        visitService.save(catVisit);

        System.out.println("Loaded owners ...");

        Vet vet1 = Vet.builder().id(1L).firstname("Sam").lastname("Axe").build();
        vet1.getSpecialities().add(radiology);

        vetService.save(vet1);

        Vet vet2 = Vet.builder().id(2L).firstname("Jessie").lastname("Porter").build();
        vet2.getSpecialities().add(surgery);

        vetService.save(vet2);

        System.out.println("Loaded vets ...");
/*
        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.getPets().add(mikesPet);*/




    }
}
