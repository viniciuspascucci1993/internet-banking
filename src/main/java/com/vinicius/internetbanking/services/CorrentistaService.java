package com.vinicius.internetbanking.services;

import com.vinicius.internetbanking.dto.CorrentistaDTO;
import com.vinicius.internetbanking.entities.Correntista;
import com.vinicius.internetbanking.repositories.CorrentistaRepository;
import com.vinicius.internetbanking.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CorrentistaService {

    @Autowired
    private CorrentistaRepository correntistaRepository;

    @Transactional(readOnly = true)
    public CorrentistaDTO findById(Long id ) {

        Optional<Correntista> obj = correntistaRepository.findById(id);
        Correntista entities = obj.orElseThrow(() -> new ResourceNotFoundException("Correntista não econtrado"));

        return new CorrentistaDTO(entities);
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
