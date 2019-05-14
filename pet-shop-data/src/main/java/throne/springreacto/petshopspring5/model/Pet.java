package throne.springreacto.petshopspring5.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Pet extends BaseEntity{
    private String name;
    @ManyToOne
    //@JoinColumn(name = "pet_type")
    private PetType petType;
    @ManyToOne
    private Owner owner;
    private LocalDate birthData;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
    private Set<Visit> visits = new HashSet<>();

}
