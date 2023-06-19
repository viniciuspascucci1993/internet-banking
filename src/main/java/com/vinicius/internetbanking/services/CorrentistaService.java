package com.vinicius.internetbanking.services;

import com.vinicius.internetbanking.dto.AccountHolderDTO;
import com.vinicius.internetbanking.entities.AccountHolder;
import com.vinicius.internetbanking.repositories.AccountHolderRepository;
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
    private AccountHolderRepository accountHolderRepository;

    @Transactional(readOnly = true)
    public AccountHolderDTO findById(Long id ) {

        Optional<AccountHolder> obj = accountHolderRepository.findById(id);
        AccountHolder entities = obj.orElseThrow(() -> new ResourceNotFoundException("Correntista não econtrado"));

        return new AccountHolderDTO(entities);
    }


    public List<AccountHolder> findAll() {

        return accountHolderRepository.findAll();
    }
    public AccountHolderDTO insert(AccountHolderDTO accountHolderDTO ) {

        AccountHolder entity = new AccountHolder();
        BeanUtils.copyProperties(accountHolderDTO, entity);

        entity = accountHolderRepository.save(entity);
        return new AccountHolderDTO(entity);
    }
}
