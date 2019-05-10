package throne.springreacto.petshopspring5.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import throne.springreacto.petshopspring5.model.Owner;
import throne.springreacto.petshopspring5.model.PetType;
import throne.springreacto.petshopspring5.model.Vet;
import throne.springreacto.petshopspring5.services.OwnerService;
import throne.springreacto.petshopspring5.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {
    private final VetService vetService;
    private final OwnerService ownerService;

    public DataLoader(VetService vetService, OwnerService ownerService) {
        this.vetService = vetService;
        this.ownerService = ownerService;
    }

    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    private void loadData(){
        PetType dog = new PetType();
        dog.setName("Dog");
        //PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        //PetType savedCatPetType = petTypeService.save(cat);

        //Speciality radiology = new Speciality();
        //radiology.setDescription("Radiology");
        //Speciality savedRadiology = specialtyService.save(radiology);

        //Speciality surgery = new Speciality();
        //surgery.setDescription("Surgery");
        //Speciality savedSurgery = specialtyService.save(surgery);

        //peciality dentistry = new Speciality();
        //dentistry.setDescription("dentistry");
        //Speciality savedDentistry = specialtyService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstname("Michael");
        owner1.setLastname("Weston");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstname("Fiona");
        owner2.setLastname("Glenanne");

        ownerService.save(owner2);

        System.out.println("Loaded owners ...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstname("Sam");
        vet1.setLastname("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstname("Jessie");
        vet2.setLastname("Porter");

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
