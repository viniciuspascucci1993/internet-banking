package com.vinicius.internetbanking.services;

import com.vinicius.internetbanking.dto.AccountHolderDTO;
import com.vinicius.internetbanking.dto.MovementationAccountHolderDTO;
import com.vinicius.internetbanking.entities.MovementationAccountHolder;
import com.vinicius.internetbanking.repositories.MovementAccountHolderRepository;
import com.vinicius.internetbanking.services.exceptions.ExpectedDateHasNotYetArrivedException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

@Service
public class MovementAccountHolderService {

    private static final String EXPECTED_DATE =
            "the expected date has not yet arrived, " +
                    "please wait for the next day for future releases in the movement of the day";

    @Autowired
    private MovementAccountHolderRepository movementAccountHolderRepository;

    public MovementationAccountHolderDTO insert(MovementationAccountHolderDTO movementationAccountHolderDTO) {

        MovementationAccountHolder entity = new MovementationAccountHolder();
        BeanUtils.copyProperties(movementationAccountHolderDTO, entity);

        entity = movementAccountHolderRepository.save(entity);
        return new MovementationAccountHolderDTO(entity);
    }

    public Page<MovementationAccountHolderDTO> findMovementDay(String minimumDate, String maximumDate, Pageable pageable) {

        LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
        LocalDate min = minimumDate.equals("") ? today.minusDays(365) : LocalDate.parse(minimumDate);
        LocalDate max = maximumDate.equals("") ? today : LocalDate.parse(maximumDate);

        if (min.isEqual(today) && max.isEqual(today)) {
            return movementAccountHolderRepository.findMovementPerDay(min, max, pageable);
        } else {
            throw new ExpectedDateHasNotYetArrivedException(EXPECTED_DATE);
        }
    }
}
