package com.vinicius.internetbanking.services;

import com.vinicius.internetbanking.entities.MovementationAccountHolder;
import com.vinicius.internetbanking.repositories.MovementAccountHolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

@Service
public class MovementAccountHolderService {

    @Autowired
    private MovementAccountHolderRepository movementAccountHolderRepository;

    public Page<MovementationAccountHolder> findMovementDay(String minimumDate, String maximumDate, Pageable pageable) {

        LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
        LocalDate min = minimumDate.equals("") ? today.minusDays(365) : LocalDate.parse(minimumDate);
        LocalDate max = maximumDate.equals("") ? today : LocalDate.parse(maximumDate);


        return movementAccountHolderRepository.findMovementPerDay(min, max, pageable);
    }
}
