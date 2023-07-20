package com.vinicius.internetbanking.controller;

import com.vinicius.internetbanking.entities.MovementationAccountHolder;
import com.vinicius.internetbanking.services.MovementAccountHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/movements")
public class MovementAccountHolderController {

    @Autowired
    private MovementAccountHolderService movementAccountHolderService;

    @GetMapping("/movement-day")
    public ResponseEntity<Page<MovementationAccountHolder>> findMovementDay(
            @RequestParam(value = "minimumDate", defaultValue = "") String minimumDate,
            @RequestParam(value = "maximumDate", defaultValue = "") String maximumDate,
            Pageable pageable
    ) {
        return ResponseEntity.ok().body(movementAccountHolderService.
                findMovementDay(minimumDate, maximumDate, pageable));
    }
}
