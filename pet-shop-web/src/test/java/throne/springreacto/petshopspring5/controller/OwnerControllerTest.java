package throne.springreacto.petshopspring5.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import throne.springreacto.petshopspring5.model.Owner;
import throne.springreacto.petshopspring5.services.OwnerService;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

    @Mock
    OwnerService ownerService;
    @Mock
    Model model;
    @InjectMocks
    OwnerController sut;

    Set<Owner> ownerSet;

    MockMvc mockMvc;
    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(sut).build();

        ownerSet = new HashSet<>();
        ownerSet.add(Owner.builder().id(1L).build());
        ownerSet.add(Owner.builder().id(2L).build());
    }

    @Test
    void listOwners() throws Exception{
        //GIVEN
        when(ownerService.findAll()).thenReturn(ownerSet);
        //WHEN
        mockMvc.perform(get("/owners/"))
        //THEN
                .andExpect(status().is(200))
                .andExpect(view().name("owner/index"))
                .andExpect(model().attribute("owners", hasSize(2)));
    }

    @Test
    void listOwnersByIndex() throws Exception{
        //GIVEN
        when(ownerService.findAll()).thenReturn(ownerSet);
        //WHEN
        mockMvc.perform(get("/owners/index"))
                //THEN
                .andExpect(status().is(200))
                .andExpect(view().name("owner/index"))
                .andExpect(model().attribute("owners", hasSize(2)));
    }

    @Test
    void findOwner() throws Exception{
        mockMvc.perform(get("/owners/find")).andExpect(view().name("notImplementedYet"))
                .andExpect(status().is(200));
        verifyZeroInteractions(ownerService);
    }
}