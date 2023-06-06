package com.vinicius.internetbanking.services;

import com.vinicius.internetbanking.dto.CorrentistaDTO;
import com.vinicius.internetbanking.dto.ExtratoCorrentistaDTO;
import com.vinicius.internetbanking.entities.Correntista;
import com.vinicius.internetbanking.entities.ExtratoCorrentista;
import com.vinicius.internetbanking.repositories.CorrentistaRepository;
import com.vinicius.internetbanking.repositories.ExtratoCorrentistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;

@Service
public class CorrentistaService {

    @Autowired
    private CorrentistaRepository correntistaRepository;

    @Autowired
    private ExtratoCorrentistaRepository extratoCorrentistaRepository;

    @Transactional(readOnly = true)
    public ExtratoCorrentistaDTO findById(Long id ) {

        Optional<ExtratoCorrentista> obj = extratoCorrentistaRepository.findById(id);
        ExtratoCorrentista entities = obj.orElseThrow(() -> new RuntimeException("Extract Not Found"));

        return new ExtratoCorrentistaDTO(entities);
    }

    public ExtratoCorrentista depositarValor(Long id, Double valorDeposito) {
        ExtratoCorrentista obj = extratoCorrentistaRepository.findById(id).get();
        if (valorDeposito > 0) {
            obj.getCorrentista().setSaldo(obj.getCorrentista().getSaldo().
                    add(new BigDecimal(valorDeposito)));
            obj.setDescricao("Seu deposito foi realizado com sucesso!");
        } else {
            obj.setDescricao("Não foi possivel realizar o deposito!");
        }

        obj.getCorrentista().setSaldo(obj.getCorrentista().getSaldo());
        return obj;
    }

    public ExtratoCorrentista sacarValor(Long id, Double valorDeSaque) {
        ExtratoCorrentista obj = extratoCorrentistaRepository.findById(id).get();

        if (valorDeSaque <= 100.0) {
            obj.setDescricao("Isento de Taxa de Saque");

        } else if (valorDeSaque > 100.00 && valorDeSaque <= 300.0) {
            BigDecimal valorSaque = BigDecimal.valueOf(valorDeSaque);
            BigDecimal saldo = obj.getCorrentista().getSaldo();
            BigDecimal percentual = obj.getCorrentista().getSaldo().divide(new BigDecimal(100)).multiply(new BigDecimal(0.4));
            percentual = percentual.setScale(2, RoundingMode.UP);
            BigDecimal resultado = valorSaque.add(percentual);
            resultado = saldo.subtract(resultado);
            obj.getCorrentista().setSaldo(resultado);
            obj.setDescricao("Taxa de 0.4%");

        } else if (valorDeSaque > 300.0 && valorDeSaque <= 1500.0) {
            BigDecimal valorSaque = BigDecimal.valueOf(valorDeSaque);
            BigDecimal saldo = obj.getCorrentista().getSaldo();
            BigDecimal percentual = obj.getCorrentista().getSaldo().divide(new BigDecimal(100)).multiply(new BigDecimal(1));
            percentual = percentual.setScale(2, RoundingMode.UP);
            BigDecimal resultado = valorSaque.add(percentual);
            resultado = saldo.subtract(resultado);
            obj.getCorrentista().setSaldo(resultado);
            obj.setDescricao("Taxa de 1%");


        } else if (obj.getCorrentista().getIsPlanoExclusive().equals(true)) {
            obj.setDescricao("Isento de Taxa de Saque");

        } else {
            obj.setDescricao("O Seguinte Correntista Não Possui o Plano Exclusive!");
        }
        return obj;
    }


    public List<Correntista> findAll() {

        return correntistaRepository.findAll();
    }
    public CorrentistaDTO insert(CorrentistaDTO correntistaDTO ) {

        Correntista entity = new Correntista();
        copyDtoToEntity(correntistaDTO, entity);

        entity = correntistaRepository.save(entity);
        return new CorrentistaDTO(entity);
    }

    private void copyDtoToEntity(CorrentistaDTO correntistaDTO, Correntista entity) {

        entity.setNome(correntistaDTO.getNome());
        entity.setIsPlanoExclusive(correntistaDTO.getIsPlanoExclusive());
        entity.setSaldo(correntistaDTO.getSaldo());
        entity.setNumeroConta(correntistaDTO.getNumeroConta());
        entity.setDataNascimento(correntistaDTO.getDataNascimento());
    }
}
