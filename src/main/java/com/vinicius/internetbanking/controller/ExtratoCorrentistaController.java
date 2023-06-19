package com.vinicius.internetbanking.controller;

import com.vinicius.internetbanking.entities.ExtractAccountHolder;
import com.vinicius.internetbanking.services.ExtratoCorrentistaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/extracts")
@Tag(name = "Internet Banking", description = "Simulação Internet Banking")
public class ExtratoCorrentistaController {

    @Autowired
    private ExtratoCorrentistaService extratoCorrentistaService;

    @Operation(
            summary = "Operation to deposit a certain amount",
            description = "Operation to deposit a certain amount")
    @GetMapping("/depositValue/{id}/{depositAmount}")
    public ResponseEntity<ExtractAccountHolder> depositarValor(@PathVariable("id") Long id,
                                                               @PathVariable("depositAmount") Double depositAmount) {
        ExtractAccountHolder extractAccountHolder = extratoCorrentistaService.depositarValor(id, depositAmount);
        return ResponseEntity.ok(extractAccountHolder);
    }

    @Operation(
            summary = "Operação para retornar o extrato do correntista com o valor do saque atualizado.",
            description = "Operação que irá retornar uma lista de correntistas.")
    @GetMapping("/withdrawValue/{id}/{value}")
    public ResponseEntity<ExtractAccountHolder> sacarValor(@PathVariable("id") Long id,
                                                           @PathVariable("value") Double value) {
        ExtractAccountHolder extractAccountHolder = extratoCorrentistaService.sacarValor(id, value);
        extractAccountHolder.getAccountHolder().setExclusivePlan(extractAccountHolder.getAccountHolder().
                getExclusivePlan());
        return ResponseEntity.ok(extractAccountHolder);
    }
}
