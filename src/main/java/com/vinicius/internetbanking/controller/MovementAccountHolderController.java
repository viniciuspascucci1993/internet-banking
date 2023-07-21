package com.vinicius.internetbanking.controller;

import com.vinicius.internetbanking.dto.AccountHolderDTO;
import com.vinicius.internetbanking.dto.MovementationAccountHolderDTO;
import com.vinicius.internetbanking.services.MovementAccountHolderService;
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
public class MovementAccountHolderController {

    @Autowired
    private MovementAccountHolderService movementAccountHolderService;

    @PostMapping("/release-movimentation")
    public ResponseEntity<MovementationAccountHolderDTO> insert(@Valid @RequestBody MovementationAccountHolderDTO
                                                                            movementationAccountHolderDTO) {

        movementationAccountHolderDTO = movementAccountHolderService.insert(movementationAccountHolderDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(movementationAccountHolderDTO.getId()).toUri();

        return ResponseEntity.created(uri).body(movementationAccountHolderDTO);
    }

    @GetMapping("/movement-day/{idMovement}")
    public ResponseEntity<Page<MovementationAccountHolderDTO>> findMovementDay(
            @RequestParam(value = "minimumDate", defaultValue = "") String minimumDate,
            @RequestParam(value = "maximumDate", defaultValue = "") String maximumDate,
            Pageable pageable
    ) {
        return ResponseEntity.ok().body(movementAccountHolderService.
                findMovementDay(minimumDate, maximumDate, pageable));
    }
}
