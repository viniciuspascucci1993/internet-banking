package com.vinicius.internetbanking.controller;

import com.vinicius.internetbanking.dto.CorrentistaDTO;
import com.vinicius.internetbanking.dto.ExtratoCorrentistaDTO;
import com.vinicius.internetbanking.entities.Correntista;
import com.vinicius.internetbanking.entities.ExtratoCorrentista;
import com.vinicius.internetbanking.services.CorrentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/correntistas")
@CrossOrigin(origins = "*")
public class CorrentistaController {

    @Autowired
    private CorrentistaService correntistaService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ExtratoCorrentistaDTO> findById(@PathVariable("id") Long id ) {

        ExtratoCorrentistaDTO dto = correntistaService.findById( id );
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping("/depositarValor/{id}/{valorDeposito}")
    public ResponseEntity<ExtratoCorrentista> depositarValor(@PathVariable("id") Long id,
                                                             @PathVariable("valorDeposito") Double valorDeposito) {
        ExtratoCorrentista extratoCorrentista = correntistaService.depositarValor(id, valorDeposito);
        return ResponseEntity.ok(extratoCorrentista);
    }

    @GetMapping("/sacarValor/{id}/{valorSaque}")
    public ResponseEntity<ExtratoCorrentista> sacarValor(@PathVariable("id") Long id,
                                                         @PathVariable("valorSaque") Double valorSaque) {
        ExtratoCorrentista extratoCorrentista = correntistaService.sacarValor(id, valorSaque);
        extratoCorrentista.getCorrentista().setIsPlanoExclusive(extratoCorrentista.getCorrentista().getIsPlanoExclusive());
        return ResponseEntity.ok(extratoCorrentista);
    }
    @GetMapping
    public ResponseEntity<List<Correntista>> findAll() {
        List<Correntista> result = correntistaService.findAll();
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<CorrentistaDTO> insert(@RequestBody CorrentistaDTO correntistaDTO) {
        correntistaDTO = correntistaService.insert(correntistaDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(correntistaDTO.getId()).toUri();

        return ResponseEntity.created(uri).body(correntistaDTO);
    }
}
