package throne.springreacto.petshopspring5.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import throne.springreacto.petshopspring5.model.Owner;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class OwnerServiceMapTest {
    OwnerServiceMap ownerServiceMap;
    private final Long ownerId = 1L;
    private final String lastname = "Julian";
    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetServiceMap(), new PetTypeServiceMap());
        ownerServiceMap.save(Owner.builder().id(ownerId).lastname(lastname).build());
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerServiceMap.findAll();

        assertEquals(1, owners.size());

    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(ownerId);
        Set<Owner> owners = ownerServiceMap.findAll();

        assertEquals(0, owners.size());

    }

    @Test
    void delete() {
        ownerServiceMap.delete(ownerServiceMap.findById(ownerId));
        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void saveExitingId() {
        Long id = 2L;
        Owner owner2 = Owner.builder().id(id).build();
        ownerServiceMap.save(owner2);

        assertEquals(id, owner2.getId());
    }
    @Test
    void saveNoId() {
        Owner owner = ownerServiceMap.save(Owner.builder().build());
        assertNotNull(owner.getId());
        assertNotNull(owner);
    }

    @Test
    void findById() {
        Owner owner = ownerServiceMap.findById(ownerId);
        assertEquals(ownerId, owner.getId());
    }

    @Test
    void findByLastName() {
        Owner owner = ownerServiceMap.findByLastName(lastname);
        assertNotNull(owner);
        assertEquals(ownerId, owner.getId());
    }
}