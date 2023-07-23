package com.vinicius.internetbanking.controller;

import com.vinicius.internetbanking.dto.AccountHolderDTO;
import com.vinicius.internetbanking.dto.ExtractAccountHolderDTO;
import com.vinicius.internetbanking.entities.ExtractAccountHolder;
import com.vinicius.internetbanking.services.ExtractAccountHolderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/extracts")
public class ExtractAccountHolderController {

    @Autowired
    private ExtractAccountHolderService extractAccountHolderService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ExtractAccountHolderDTO> findById(@PathVariable("id") Long id ) {

        ExtractAccountHolderDTO dto = extractAccountHolderService.findById( id );
        return ResponseEntity.ok().body(dto);

    }

    @PostMapping
    public ResponseEntity<ExtractAccountHolderDTO> insert(@Valid @RequestBody ExtractAccountHolderDTO
                                                                      extractAccountHolderDTO) {

        extractAccountHolderDTO = extractAccountHolderService.insert(extractAccountHolderDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(extractAccountHolderDTO.getIdExtractAccountHolder()).toUri();

        return ResponseEntity.created(uri).body(extractAccountHolderDTO);
    }

    @GetMapping("/depositValue/{id}/{depositAmount}")
    public ResponseEntity<ExtractAccountHolder> depositarValor(@PathVariable("id") Long id,
                                                               @PathVariable("depositAmount") Double depositAmount) {
        ExtractAccountHolder extractAccountHolder = extractAccountHolderService.depositarValor(id, depositAmount);
        return ResponseEntity.ok(extractAccountHolder);
    }

    @GetMapping("/withdrawValue/{id}/{value}")
    public ResponseEntity<ExtractAccountHolder> sacarValor(@PathVariable("id") Long id,
                                                           @PathVariable("value") Double value) {
        ExtractAccountHolder extractAccountHolder = extractAccountHolderService.sacarValor(id, value);
        extractAccountHolder.getAccountHolder().setExclusivePlan(extractAccountHolder.getAccountHolder().
                getExclusivePlan());
        return ResponseEntity.ok(extractAccountHolder);
    }
}
