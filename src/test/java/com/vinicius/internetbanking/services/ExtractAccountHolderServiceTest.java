package com.vinicius.internetbanking.services;

import com.vinicius.internetbanking.entities.ExtractAccountHolder;
import com.vinicius.internetbanking.repositories.ExtractAccountHolderRepository;
import com.vinicius.internetbanking.services.exceptions.InvalidDepositException;
import com.vinicius.internetbanking.tests.Factory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class ExtractAccountHolderServiceTest {

    @InjectMocks
    private ExtratoCorrentistaService extratoCorrentistaService;

    @Mock
    private ExtractAccountHolderRepository extractAccountHolderRepository;

    private ExtractAccountHolder extratoCorrentista;

    private Long existingId;
    private Long nonExistingId;

    @BeforeEach
    public void setup() throws Exception {
        existingId = 1L;
        nonExistingId = 1000L;
        extratoCorrentista = Factory.createExtractAccountHolder();
        when(extractAccountHolderRepository.findById(existingId)).thenReturn(Optional.of(extratoCorrentista));
        when(extractAccountHolderRepository.findById(nonExistingId)).thenReturn(Optional.empty());
    }

    @Test
    public void shouldReturnADepositoValueExtractAccountHolder() {

        ExtractAccountHolder depositValue =
                extratoCorrentistaService.depositarValor(1L, 150.0);

        Assertions.assertNotNull(depositValue);
    }

    @Test
    public void shouldReturnAnElseCaseWhenDepositoValueIsNull() {
        Double errorValueException = -1.0;

        Assertions.assertThrows(InvalidDepositException.class, () ->
                extratoCorrentistaService.depositarValor(1L, errorValueException));
    }

    @Test
    public void shouldReturnAnWitdrawValue() {

        ExtractAccountHolder withdrawValue =
                extratoCorrentistaService.sacarValor(1L, 450.0);
        Assertions.assertNotNull(withdrawValue);
    }

    @Test
    public void shouldReturnAnWitdrawValueWhenIsFreeTax() {

        ExtractAccountHolder withdrawValue =
                extratoCorrentistaService.sacarValor(1L, 95.00);
        Assertions.assertNotNull(withdrawValue);
    }

    @Test
    public void shouldReturnAnWitdrawValueWhenIsBetweenOneHundredAndThreeHundredValue() {

        ExtractAccountHolder withdrawValue =
                extratoCorrentistaService.sacarValor(1L, 250.00);
        Assertions.assertNotNull(withdrawValue);
        Assertions.assertEquals(13749.00, withdrawValue.getAccountHolder().getBallance().intValue());
    }

    @Test
    public void shouldReturnAnWitdrawValueWhenIsPlanoExclusive() {

        ExtractAccountHolder withdrawBalue =
                extratoCorrentistaService.sacarValor(1L, 2500.00);
        Assertions.assertNotNull(withdrawBalue);
        Assertions.assertEquals("Isento de Taxa de Saque",
                withdrawBalue.getDescription());
    }
}
