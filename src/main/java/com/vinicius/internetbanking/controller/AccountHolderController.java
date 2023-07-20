package com.vinicius.internetbanking.controller;

import com.vinicius.internetbanking.dto.AccountHolderDTO;
import com.vinicius.internetbanking.entities.AccountHolder;
import com.vinicius.internetbanking.services.AccountHolderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/account-holders")
public class AccountHolderController {

    @Autowired
    private AccountHolderService accountHolderService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<AccountHolderDTO> findById(@PathVariable("id") Long id ) {

        AccountHolderDTO dto = accountHolderService.findById( id );
        return ResponseEntity.ok().body(dto);

    }

    @GetMapping
    public ResponseEntity<Page<AccountHolderDTO>> findAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
                          @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
                          @RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
                          @RequestParam(value = "direction", defaultValue = "ASC") String direction) {
        Page<AccountHolder> listAccountHolders = accountHolderService.findPage( page, linesPerPage, orderBy, direction );

        Page<AccountHolderDTO> listaDto = listAccountHolders.map(AccountHolderDTO::new);

        return ResponseEntity.ok().body(listaDto);
    }

    @PostMapping
    public ResponseEntity<AccountHolderDTO> insert(@Valid @RequestBody AccountHolderDTO accountHolderDTO) {

        accountHolderDTO = accountHolderService.insert(accountHolderDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(accountHolderDTO.getId()).toUri();

        return ResponseEntity.created(uri).body(accountHolderDTO);
    }
}
