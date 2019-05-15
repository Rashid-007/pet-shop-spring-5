package throne.springreacto.petshopspring5.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Visit extends BaseEntity{
    @Builder
    public Visit(Long id, LocalDate date, String description, Pet pet){
        super(id);
        this.date = date;
        this.description = description;
        this.pet = pet;
    }
    private LocalDate date;
    private String description;
    @ManyToOne
    private Pet pet;
}
