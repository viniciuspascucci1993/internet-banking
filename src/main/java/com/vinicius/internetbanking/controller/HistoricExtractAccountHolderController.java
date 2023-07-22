package com.vinicius.internetbanking.controller;

import com.vinicius.internetbanking.dto.HistoricExtractDTO;
import com.vinicius.internetbanking.services.HistoricExtractService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/movements")
public class HistoricExtractAccountHolderController {

    @Autowired
    private HistoricExtractService historicExtractService;

    @PostMapping("/release-movimentation")
    public ResponseEntity<HistoricExtractDTO> insert(@Valid @RequestBody HistoricExtractDTO
                                                                            historicExtractDTO) {

        historicExtractDTO = historicExtractService.insert(historicExtractDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(historicExtractDTO.getId()).toUri();

        return ResponseEntity.created(uri).body(historicExtractDTO);
    }

    @GetMapping("/movement-day")
    public ResponseEntity<Page<HistoricExtractDTO>> findMovementDay(
            @RequestParam(value = "minimumDate", defaultValue = "") String minimumDate,
            @RequestParam(value = "maximumDate", defaultValue = "") String maximumDate,
            Pageable pageable
    ) {
        return ResponseEntity.ok().body(historicExtractService.
                findMovementDay(minimumDate, maximumDate, pageable));
    }
}
