package throne.springreacto.petshopspring5.model;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Pet {
    private PetType petType;
    private Owner owner;
    private LocalDate birthData;

}
