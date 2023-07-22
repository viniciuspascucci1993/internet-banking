package com.vinicius.internetbanking.services;

import com.vinicius.internetbanking.dto.HistoricExtractDTO;
import com.vinicius.internetbanking.entities.HistoricExtract;
import com.vinicius.internetbanking.repositories.HistoricExtractRepository;
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
public class HistoricExtractService {

    private static final String EXPECTED_DATE =
            "the expected date has not yet arrived, " +
                    "please wait for the next day for future releases in the movement of the day";

    @Autowired
    private HistoricExtractRepository historicExtractRepository;

    public HistoricExtractDTO insert(HistoricExtractDTO historicExtractDTO) {

        HistoricExtract entity = new HistoricExtract();
        BeanUtils.copyProperties(historicExtractDTO, entity);

        entity = historicExtractRepository.save(entity);
        return new HistoricExtractDTO(entity);
    }

    public Page<HistoricExtractDTO> findMovementDay(String minimumDate, String maximumDate, Pageable pageable) {

        LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
        LocalDate min = minimumDate.equals("") ? today.minusDays(365) : LocalDate.parse(minimumDate);
        LocalDate max = maximumDate.equals("") ? today : LocalDate.parse(maximumDate);

        if (min.isEqual(today) && max.isEqual(today)) {
            return historicExtractRepository.findHistoricExtractMovimentationDay(min, max, pageable);
        } else {
            throw new ExpectedDateHasNotYetArrivedException(EXPECTED_DATE);
        }
    }
}
