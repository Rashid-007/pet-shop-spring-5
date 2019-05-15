package throne.springreacto.petshopspring5.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass //Hey JPA, please do not do anything for this POJO in db. Other classes inherits from this and it is fine.
public class Person extends BaseEntity{
    public Person(Long id, String firstname, String lastname){
        super(id);
        this.firstname = firstname;
        this.lastname = lastname;
    }
    private String firstname;
    private String lastname;
}
