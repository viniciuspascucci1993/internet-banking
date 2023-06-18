package com.vinicius.internetbanking.controller;

import com.vinicius.internetbanking.dto.CorrentistaDTO;
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
            summary = "Operação para retornar correntista pelo ID.",
            description = "Operação que irá retornar correntista pelo ID.")
    @GetMapping(value = "/{id}")
    public ResponseEntity<CorrentistaDTO> findById(@PathVariable("id") Long id ) {

        CorrentistaDTO dto = correntistaService.findById( id );
        return ResponseEntity.ok().body(dto);
    }

    @Operation(
            summary = "Operação para retornar correntista todos os correntistas.",
            description = "Operação que irá retornar uma lista de correntistas.")
    @GetMapping
    public ResponseEntity<List<AccountHolder>> findAll() {
        List<AccountHolder> result = correntistaService.findAll();
        return ResponseEntity.ok(result);
    }

    @Operation(
            summary = "Operação para cadastrar um novo correntista.",
            description = "Operação que irá retornar um novo correntista cadastrado.")
    @PostMapping
    public ResponseEntity<CorrentistaDTO> insert(@Valid @RequestBody CorrentistaDTO correntistaDTO) {

        correntistaDTO = correntistaService.insert(correntistaDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(correntistaDTO.getId()).toUri();

        return ResponseEntity.created(uri).body(correntistaDTO);
    }
}
