package com.vinicius.internetbanking.services;

import com.vinicius.internetbanking.dto.CorrentistaDTO;
import com.vinicius.internetbanking.entities.AccountHolder;
import com.vinicius.internetbanking.repositories.CorrentistaRepository;
import com.vinicius.internetbanking.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.BeanUtils;
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

        Optional<AccountHolder> obj = correntistaRepository.findById(id);
        AccountHolder entities = obj.orElseThrow(() -> new ResourceNotFoundException("Correntista não econtrado"));

        return new CorrentistaDTO(entities);
    }


    public List<AccountHolder> findAll() {

        return correntistaRepository.findAll();
    }
    public CorrentistaDTO insert(CorrentistaDTO correntistaDTO ) {

        AccountHolder entity = new AccountHolder();
        BeanUtils.copyProperties(correntistaDTO, entity);

        entity = correntistaRepository.save(entity);
        return new CorrentistaDTO(entity);
    }
}
