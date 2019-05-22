package throne.springreacto.petshopspring5.services.springdatajpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import throne.springreacto.petshopspring5.model.Owner;
import throne.springreacto.petshopspring5.repositories.OwnerRepository;
import throne.springreacto.petshopspring5.repositories.PetRepository;
import throne.springreacto.petshopspring5.repositories.PetTypeRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    public static final String LASTNAME = "Rashid";

    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks //System Under Test (sut)
    OwnerSDJpaService sut;

    Owner testOwner;

    @BeforeEach
    void setUp() {
        testOwner = Owner.builder().id(1L).lastname(LASTNAME).build();
    }

    @Test
    void findByLastName() {
        //GIVEN
        when(ownerRepository.findByLastname(LASTNAME)).thenReturn(testOwner);

        //WHEN
        Owner ownerFound = sut.findByLastName(LASTNAME);

        //THEN
        assertEquals(LASTNAME, ownerFound.getLastname());
        verify(ownerRepository).findByLastname(any());
    }

    @Test
    void findAll() {
        Set<Owner> returnOwnersSet = new HashSet<>();
        returnOwnersSet.add(Owner.builder().id(1l).build());
        returnOwnersSet.add(Owner.builder().id(2l).build());

        when(ownerRepository.findAll()).thenReturn(returnOwnersSet);

        Set<Owner> owners = sut.findAll();

        assertNotNull(owners);
        assertEquals(2, owners.size());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(testOwner));

        Owner owner = sut.findById(1L);

        assertNotNull(owner);
    }

    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());

        Owner owner = sut.findById(1L);

        assertNull(owner);
    }

    @Test
    void save() {
        Owner ownerToSave = Owner.builder().id(1L).build();

        when(ownerRepository.save(any())).thenReturn(testOwner);

        Owner savedOwner = sut.save(ownerToSave);

        assertNotNull(savedOwner);

        verify(ownerRepository).save(any());
    }

    @Test
    void delete() {
        sut.delete(testOwner);

        //default is 1 times
        verify(ownerRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        sut.deleteById(1L);

        verify(ownerRepository).deleteById(anyLong());
    }
}