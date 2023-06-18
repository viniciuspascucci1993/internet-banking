package com.vinicius.internetbanking.services;

import com.vinicius.internetbanking.dto.CorrentistaDTO;
import com.vinicius.internetbanking.entities.AccountHolder;
import com.vinicius.internetbanking.repositories.CorrentistaRepository;
import com.vinicius.internetbanking.services.exceptions.ResourceNotFoundException;
import com.vinicius.internetbanking.tests.Factory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class CorrentistaServiceTest {

    @InjectMocks
    private CorrentistaService correntistaService;

    @Mock
    private CorrentistaRepository correntistaRepository;

    private Long existingId;
    private Long nonExistingId;
    private AccountHolder correntista;

    @BeforeEach
    public void setup() throws Exception {
        existingId = 1L;
        nonExistingId = 1000L;
        correntista = Factory.createCorrentista();

        when(correntistaRepository.save(ArgumentMatchers.any())).thenReturn(correntista);

        when(correntistaRepository.findById(existingId)).thenReturn(Optional.of(correntista));
        when(correntistaRepository.findById(nonExistingId)).thenReturn(Optional.empty());

        when(correntistaRepository.save(ArgumentMatchers.any())).thenReturn(correntista);
    }

    @Test
    public void insertShouldReturnAnObjectAccountHolderDto() {
        CorrentistaDTO correntistaDTO = Factory.createCorrentistaDto();
        CorrentistaDTO insertCorrentistaDto = correntistaService.insert(correntistaDTO);

        insertCorrentistaDto.setId(null);
        Assertions.assertNotNull(correntistaDTO.getId());
    }

    @Test
    public void findByIdShouldReturnAnObjectAccountHolderDtoWhenIdExists() {

        CorrentistaDTO correntistaDTO = correntistaService.findById(existingId);

        Assertions.assertNotNull(correntistaDTO);
        verify(correntistaRepository, times(1)).findById(existingId);
    }

    @Test
    public void findByIdShouldReturnAnObjectAccountHolderDtoWhenNonExistingId() {

        Assertions.assertThrows(ResourceNotFoundException.class, () ->
                correntistaService.findById(nonExistingId));
        verify(correntistaRepository, times(1)).findById(nonExistingId);
    }

    @Test
    public void findAllShouldReturnAllAccountHoldersoBJECTS() {
        List<AccountHolder> correntista = correntistaService.findAll();
        verify(correntistaRepository, times(1)).findAll();

        Assertions.assertNotNull(correntista);
    }
}
