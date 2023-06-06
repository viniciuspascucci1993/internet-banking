package com.vinicius.internetbanking.controller;

import com.vinicius.internetbanking.dto.CorrentistaDTO;
import com.vinicius.internetbanking.dto.ExtratoCorrentistaDTO;
import com.vinicius.internetbanking.entities.Correntista;
import com.vinicius.internetbanking.entities.ExtratoCorrentista;
import com.vinicius.internetbanking.services.CorrentistaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/correntistas")
@CrossOrigin(origins = "*")
@Tag(name = "Internet Banking", description = "Simulação Internet Bankink")
public class CorrentistaController {

    @Autowired
    private CorrentistaService correntistaService;

    @Operation(
            summary = "Operação para retornar correntista pelo ID.",
            description = "Operação que irá retornar correntista pelo ID.")
    @GetMapping(value = "/{id}")
    public ResponseEntity<ExtratoCorrentistaDTO> findById(@PathVariable("id") Long id ) {

        ExtratoCorrentistaDTO dto = correntistaService.findById( id );
        return ResponseEntity.ok().body(dto);
    }

    @Operation(
            summary = "Operação para retornar o extrato do correntista com o valor do deposito atualizado.",
            description = "Operação que irá retornar uma lista de correntistas.")
    @GetMapping("/depositarValor/{id}/{valorDeposito}")
    public ResponseEntity<ExtratoCorrentista> depositarValor(@PathVariable("id") Long id,
                                                             @PathVariable("valorDeposito") Double valorDeposito) {
        ExtratoCorrentista extratoCorrentista = correntistaService.depositarValor(id, valorDeposito);
        return ResponseEntity.ok(extratoCorrentista);
    }

    @Operation(
            summary = "Operação para retornar o extrato do correntista com o valor do saque atualizado.",
            description = "Operação que irá retornar uma lista de correntistas.")
    @GetMapping("/sacarValor/{id}/{valorSaque}")
    public ResponseEntity<ExtratoCorrentista> sacarValor(@PathVariable("id") Long id,
                                                         @PathVariable("valorSaque") Double valorSaque) {
        ExtratoCorrentista extratoCorrentista = correntistaService.sacarValor(id, valorSaque);
        extratoCorrentista.getCorrentista().setIsPlanoExclusive(extratoCorrentista.getCorrentista().getIsPlanoExclusive());
        return ResponseEntity.ok(extratoCorrentista);
    }

    @Operation(
            summary = "Operação para retornar correntista todos os correntistas.",
            description = "Operação que irá retornar uma lista de correntistas.")
    @GetMapping
    public ResponseEntity<List<Correntista>> findAll() {
        List<Correntista> result = correntistaService.findAll();
        return ResponseEntity.ok(result);
    }

    @Operation(
            summary = "Operação para cadastrar um novo correntista.",
            description = "Operação que irá retornar um novo correntista cadastrado.")
    @PostMapping
    public ResponseEntity<CorrentistaDTO> insert(@RequestBody CorrentistaDTO correntistaDTO) {
        correntistaDTO = correntistaService.insert(correntistaDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(correntistaDTO.getId()).toUri();

        return ResponseEntity.created(uri).body(correntistaDTO);
    }
}
