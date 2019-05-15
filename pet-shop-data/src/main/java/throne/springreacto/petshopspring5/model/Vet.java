package throne.springreacto.petshopspring5.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Vet extends Person {
    @Builder
    public Vet(Long id, String firstname, String lastname, Set<Speciality> specialities){
        super(id, firstname, lastname);

        if(specialities != null || specialities.size() > 0){
            this.specialities = specialities;
        }
    }
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "vet_specialities", joinColumns = @JoinColumn(name = "vet_id"), inverseJoinColumns = @JoinColumn(name = "speciality_id"))
    private Set<Speciality> specialities = new HashSet<>();
}
