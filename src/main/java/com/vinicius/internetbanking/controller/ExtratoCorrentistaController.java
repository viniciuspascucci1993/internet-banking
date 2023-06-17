package com.vinicius.internetbanking.controller;

import com.vinicius.internetbanking.dto.CorrentistaDTO;
import com.vinicius.internetbanking.dto.ExtratoCorrentistaDTO;
import com.vinicius.internetbanking.entities.Correntista;
import com.vinicius.internetbanking.entities.ExtratoCorrentista;
import com.vinicius.internetbanking.services.CorrentistaService;
import com.vinicius.internetbanking.services.ExtratoCorrentistaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/extract")
@Tag(name = "Internet Banking", description = "Simulação Internet Banking")
public class ExtratoCorrentistaController {

    @Autowired
    private ExtratoCorrentistaService extratoCorrentistaService;

    @Operation(
            summary = "Operação para retornar o extrato do correntista com o valor do deposito atualizado.",
            description = "Operação que irá retornar uma lista de correntistas.")
    @GetMapping("/depositarValor/{id}/{valorDeposito}")
    public ResponseEntity<ExtratoCorrentista> depositarValor(@PathVariable("id") Long id,
                                                             @PathVariable("valorDeposito") Double valorDeposito) {
        ExtratoCorrentista extratoCorrentista = extratoCorrentistaService.depositarValor(id, valorDeposito);
        return ResponseEntity.ok(extratoCorrentista);
    }

    @Operation(
            summary = "Operação para retornar o extrato do correntista com o valor do saque atualizado.",
            description = "Operação que irá retornar uma lista de correntistas.")
    @GetMapping("/sacarValor/{id}/{valorSaque}")
    public ResponseEntity<ExtratoCorrentista> sacarValor(@PathVariable("id") Long id,
                                                         @PathVariable("valorSaque") Double valorSaque) {
        ExtratoCorrentista extratoCorrentista = extratoCorrentistaService.sacarValor(id, valorSaque);
        extratoCorrentista.getCorrentista().setIsPlanoExclusive(extratoCorrentista.getCorrentista().getIsPlanoExclusive());
        return ResponseEntity.ok(extratoCorrentista);
    }
}
