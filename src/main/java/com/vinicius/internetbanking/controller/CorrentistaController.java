package com.vinicius.internetbanking.controller;

import com.vinicius.internetbanking.dto.AccountHolderDTO;
import com.vinicius.internetbanking.entities.AccountHolder;
import com.vinicius.internetbanking.services.CorrentistaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/account-holders")
@Tag(name = "Internet Banking", description = "Simulação Internet Banking")
public class CorrentistaController {

    @Autowired
    private CorrentistaService correntistaService;

    @Operation(
            summary = "Operation for return Account Holder By ID.",
            description = "Operation for return Account Holder By ID.")
    @GetMapping(value = "/{id}")
    public ResponseEntity<AccountHolderDTO> findById(@PathVariable("id") Long id ) {

        AccountHolderDTO dto = correntistaService.findById( id );
        return ResponseEntity.ok().body(dto);
    }

    @Operation(
            summary = "Operation for return all Account Holders.",
            description = "Operation for return all Account Holders.")
    @GetMapping
    public ResponseEntity<List<AccountHolder>> findAll() {
        List<AccountHolder> result = correntistaService.findAll();
        return ResponseEntity.ok(result);
    }

    @Operation(
            summary = "Operation for save a new Account Holder",
            description = "Operation for save a new Account Holder.")
    @PostMapping
    public ResponseEntity<AccountHolderDTO> insert(@Valid @RequestBody AccountHolderDTO accountHolderDTO) {

        accountHolderDTO = correntistaService.insert(accountHolderDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(accountHolderDTO.getId()).toUri();

        return ResponseEntity.created(uri).body(accountHolderDTO);
    }
}
