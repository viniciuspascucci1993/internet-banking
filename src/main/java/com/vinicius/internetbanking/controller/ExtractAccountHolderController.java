package com.vinicius.internetbanking.controller;

import com.vinicius.internetbanking.entities.ExtractAccountHolder;
import com.vinicius.internetbanking.services.ExtractAccountHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/extracts")
public class ExtractAccountHolderController {

    @Autowired
    private ExtractAccountHolderService extractAccountHolderService;

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
