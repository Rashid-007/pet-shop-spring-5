package throne.springreacto.petshopspring5.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import throne.springreacto.petshopspring5.model.Owner;
import throne.springreacto.petshopspring5.services.PetService;
import throne.springreacto.petshopspring5.services.PetTypeService;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@SpringBootTest
class OwnerServiceMapIT {
    @Autowired
    OwnerServiceMap ownerServiceMap;

    @Autowired
    PetService petService;
    @Autowired
    PetTypeService petTypeService;

    @BeforeEach
    void setUp() {
        //ownerServiceMap = new OwnerServiceMap(petService, petTypeService);
    }

    @Test
    void findAll() {
        //Set<Owner> owners = ownerServiceMap.findAll();
    }

    @Test
    void deleteById() {
    }

    @Test
    void delete() {
    }

    @Test
    void save() {
    }

    @Test
    void findById() {
    }

    @Test
    void findByLastName() {
    }
}