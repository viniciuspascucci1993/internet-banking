package com.vinicius.internetbanking.controller;

import com.vinicius.internetbanking.entities.ExtratoCorrentista;
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
            summary = "Operação para retornar o extrato do correntista com o valor do deposito atualizado.",
            description = "Operação que irá retornar uma lista de correntistas.")
    @GetMapping("/depositValue/{id}/{depositAmount}")
    public ResponseEntity<ExtratoCorrentista> depositarValor(@PathVariable("id") Long id,
                                                             @PathVariable("valorDeposito") Double valorDeposito) {
        ExtratoCorrentista extratoCorrentista = extratoCorrentistaService.depositarValor(id, valorDeposito);
        return ResponseEntity.ok(extratoCorrentista);
    }

    @Operation(
            summary = "Operação para retornar o extrato do correntista com o valor do saque atualizado.",
            description = "Operação que irá retornar uma lista de correntistas.")
    @GetMapping("/withdrawValue/{id}/{value}")
    public ResponseEntity<ExtratoCorrentista> sacarValor(@PathVariable("id") Long id,
                                                         @PathVariable("valorSaque") Double valorSaque) {
        ExtratoCorrentista extratoCorrentista = extratoCorrentistaService.sacarValor(id, valorSaque);
        extratoCorrentista.getCorrentista().setIsPlanoExclusive(extratoCorrentista.getCorrentista().getIsPlanoExclusive());
        return ResponseEntity.ok(extratoCorrentista);
    }
}
