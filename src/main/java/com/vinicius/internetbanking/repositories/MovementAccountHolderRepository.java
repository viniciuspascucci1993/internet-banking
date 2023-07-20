package com.vinicius.internetbanking.repositories;

import com.vinicius.internetbanking.dto.MovementationAccountHolderDTO;
import com.vinicius.internetbanking.entities.MovementationAccountHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

public interface MovementAccountHolderRepository extends JpaRepository<MovementationAccountHolder, Long> {

    /*
     * Consulta customizada por data de movimentação da conta do correntista
     * */
    @Query("SELECT obj FROM MovementationAccountHolder " +
            "obj WHERE obj.date BETWEEN :min AND :max ORDER BY obj.nameAccountHolder DESC")
    Page<MovementationAccountHolderDTO> findMovementPerDay(LocalDate min, LocalDate max, Pageable pageable);

}
