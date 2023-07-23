package com.vinicius.internetbanking.services;

import com.vinicius.internetbanking.dto.AccountHolderDTO;
import com.vinicius.internetbanking.dto.ExtractAccountHolderDTO;
import com.vinicius.internetbanking.entities.AccountHolder;
import com.vinicius.internetbanking.entities.ExtractAccountHolder;
import com.vinicius.internetbanking.entities.HistoricExtract;
import com.vinicius.internetbanking.repositories.AccountHolderRepository;
import com.vinicius.internetbanking.repositories.ExtractAccountHolderRepository;
import com.vinicius.internetbanking.repositories.HistoricExtractRepository;
import com.vinicius.internetbanking.repositories.messaging.SendHistoricExtractAccountForValidationRepository;
import com.vinicius.internetbanking.services.exceptions.InvalidDepositException;
import com.vinicius.internetbanking.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ExtractAccountHolderService {

    @Autowired
    private ExtractAccountHolderRepository extractAccountHolderRepository;

    @Autowired
    private HistoricExtractRepository historicExtractRepository;

    @Autowired
    private SendHistoricExtractAccountForValidationRepository sendHistoricExtractAccountForValidationRepository;

    public ExtractAccountHolderDTO insert(ExtractAccountHolderDTO extractAccountHolderDTO) {

        ExtractAccountHolder entity = new ExtractAccountHolder();
        BeanUtils.copyProperties(extractAccountHolderDTO, entity);

        entity = extractAccountHolderRepository.save(entity);
        List<HistoricExtract> historicExtractList =
                historicExtractRepository.saveAll(extractAccountHolderDTO.getHistoricExtract());

        entity.setHistoricExtractList(historicExtractList);

        sendHistoricExtractAccountForValidationRepository.sendMessage(
                String.valueOf(extractAccountHolderDTO.getHistoricExtract().get(0).getDateFutureReleases()));
        return new ExtractAccountHolderDTO(entity);
    }

    @Transactional(readOnly = true)
    public ExtractAccountHolderDTO findById(Long id ) {

        Optional<ExtractAccountHolder> obj = extractAccountHolderRepository.findById(id);
        ExtractAccountHolder entities = obj.orElseThrow(() ->
                new ResourceNotFoundException("Extrato do Correntista não encontrado!"));

        return new ExtractAccountHolderDTO(entities);
    }


    public ExtractAccountHolder depositarValor(Long id, Double valorDeposito) {
        ExtractAccountHolder obj = extractAccountHolderRepository.findById(id).get();
        if (valorDeposito > 0) {
            obj.getAccountHolder().setBallance(obj.getAccountHolder().getBallance().
                    add(new BigDecimal(valorDeposito)));
            obj.setDescription("Seu deposito foi realizado com sucesso!");
        } else {
            throw new InvalidDepositException("Não foi possível realizar o deposito");
        }

        obj.getAccountHolder().setBallance(obj.getAccountHolder().getBallance());
        return obj;
    }

    public ExtractAccountHolder sacarValor(Long id, Double value) {
        ExtractAccountHolder obj = extractAccountHolderRepository.findById(id).get();


        if (value <= 100.0) {
            obj.setDescription("Isento de Taxa de Saque");

        } else if (value > 100.00 && value <= 300.0) {
            BigDecimal resultado = calcularDesconto(value, obj.getAccountHolder().getBallance(), 0.4);
            obj.getAccountHolder().setBallance(resultado);
            obj.setDescription("Taxa de 0.4%");

        } else if (value > 300.0 && value <= 1500.0) {
            BigDecimal resultado = calcularDesconto(value, obj.getAccountHolder().getBallance(), 1);
            obj.getAccountHolder().setBallance(resultado);
            obj.setDescription("Taxa de 1%");


        } else if (obj.getAccountHolder().getExclusivePlan().equals(true)) {
            obj.setDescription("Isento de Taxa de Saque");

        } else {
            obj.setDescription("O Seguinte Correntista Não Possui o Plano Exclusive!");
        }
        return obj;
    }

    private static BigDecimal calcularDesconto(double valorDeSaque, BigDecimal saldoConta, double percentualDesconto) {
        BigDecimal valorSaque = BigDecimal.valueOf(valorDeSaque);
        BigDecimal percentual = valorSaque.multiply(BigDecimal.valueOf(percentualDesconto));
        // valor de desconto
        BigDecimal valorDesconto = percentual.divide(new BigDecimal(100));
        valorDesconto = valorDesconto.setScale(2, RoundingMode.HALF_EVEN);
        valorDesconto = valorDesconto.add(valorSaque);

        BigDecimal resultado = saldoConta.subtract(valorDesconto);
        return resultado;
    }
}
