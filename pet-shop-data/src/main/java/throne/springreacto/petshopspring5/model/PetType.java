package throne.springreacto.petshopspring5.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class PetType extends BaseEntity{
    @Builder
    public PetType(Long id, String name){
        super(id);
        this.name = name;
    }
    private String name;
}
