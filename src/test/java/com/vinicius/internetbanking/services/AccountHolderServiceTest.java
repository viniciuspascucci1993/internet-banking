package com.vinicius.internetbanking.services;

import com.vinicius.internetbanking.dto.AccountHolderDTO;
import com.vinicius.internetbanking.entities.AccountHolder;
import com.vinicius.internetbanking.repositories.AccountHolderRepository;
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
public class AccountHolderServiceTest {

    @InjectMocks
    private CorrentistaService correntistaService;

    @Mock
    private AccountHolderRepository accountHolderRepository;

    private Long existingId;
    private Long nonExistingId;
    private AccountHolder correntista;

    @BeforeEach
    public void setup() throws Exception {
        existingId = 1L;
        nonExistingId = 1000L;
        correntista = Factory.createCorrentista();

        when(accountHolderRepository.save(ArgumentMatchers.any())).thenReturn(correntista);

        when(accountHolderRepository.findById(existingId)).thenReturn(Optional.of(correntista));
        when(accountHolderRepository.findById(nonExistingId)).thenReturn(Optional.empty());

        when(accountHolderRepository.save(ArgumentMatchers.any())).thenReturn(correntista);
    }

    @Test
    public void insertShouldReturnAnObjectAccountHolderDto() {
        AccountHolderDTO correntistaDTO = Factory.createCorrentistaDto();
        AccountHolderDTO insertCorrentistaDto = correntistaService.insert(correntistaDTO);

        insertCorrentistaDto.setId(null);
        Assertions.assertNotNull(correntistaDTO.getId());
    }

    @Test
    public void findByIdShouldReturnAnObjectAccountHolderDtoWhenIdExists() {

        AccountHolderDTO correntistaDTO = correntistaService.findById(existingId);

        Assertions.assertNotNull(correntistaDTO);
        verify(accountHolderRepository, times(1)).findById(existingId);
    }

    @Test
    public void findByIdShouldReturnAnObjectAccountHolderDtoWhenNonExistingId() {

        Assertions.assertThrows(ResourceNotFoundException.class, () ->
                correntistaService.findById(nonExistingId));
        verify(accountHolderRepository, times(1)).findById(nonExistingId);
    }

    @Test
    public void findAllShouldReturnAllAccountHoldersoBJECTS() {
        List<AccountHolder> correntista = correntistaService.findAll();
        verify(accountHolderRepository, times(1)).findAll();

        Assertions.assertNotNull(correntista);
    }
}
