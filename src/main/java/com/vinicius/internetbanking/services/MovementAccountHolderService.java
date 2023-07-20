package com.vinicius.internetbanking.services;

import com.vinicius.internetbanking.dto.MovementationAccountHolderDTO;
import com.vinicius.internetbanking.entities.MovementationAccountHolder;
import com.vinicius.internetbanking.repositories.MovementAccountHolderRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Optional;

@Service
public class MovementAccountHolderService {

    @Autowired
    private MovementAccountHolderRepository movementAccountHolderRepository;

    public Page<MovementationAccountHolderDTO> findMovementDay(Long id, String minimumDate, String maximumDate, Pageable pageable) {

        LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
        LocalDate min = minimumDate.equals("") ? today.minusDays(365) : LocalDate.parse(minimumDate);
        LocalDate max = maximumDate.equals("") ? today : LocalDate.parse(maximumDate);

        MovementationAccountHolder movementationAccountHolder = new MovementationAccountHolder();
        Optional<MovementationAccountHolder> movementById =
                Optional.of(movementAccountHolderRepository.findById(id).get());

        MovementationAccountHolderDTO dto = new MovementationAccountHolderDTO();
        dto.setId(movementById.get().getId());
        dto.setNameAccountHolder(movementationAccountHolder.getNameAccountHolder());
        dto.setFutureReleases(movementationAccountHolder.getFutureReleases());
        dto.setDateFutureReleases(movementById.get().getDateFutureReleases());
        dto.setDate(movementById.get().getDate());
        dto.setBalanceDateAccountHolder(movementById.get().getBalanceDateAccountHolder());
        dto.setSeveral(movementationAccountHolder.getSeveral());
        dto.setOtherTransfers(movementationAccountHolder.getOtherTransfers());
        dto.setInterestReceived(movementById.get().getInterestReceived());
        dto.setLoans(movementationAccountHolder.getLoans());
        dto.setTicket(movementationAccountHolder.getTicket());
        dto.setCreditCard(movementationAccountHolder.getCreditCard());

        BeanUtils.copyProperties(dto, movementById);
        return movementAccountHolderRepository.findMovementPerDay(min, max, pageable);
    }
}
