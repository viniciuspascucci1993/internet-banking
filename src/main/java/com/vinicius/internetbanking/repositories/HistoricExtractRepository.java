package com.vinicius.internetbanking.repositories;

import com.vinicius.internetbanking.dto.HistoricExtractDTO;
import com.vinicius.internetbanking.entities.HistoricExtract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

public interface HistoricExtractRepository extends JpaRepository<HistoricExtract, Long> {

    /*
     * Consulta customizada por data de movimentação da conta do correntista
     * */
    @Query("SELECT obj FROM HistoricExtract " +
            "obj WHERE obj.todaysDate BETWEEN :min AND :max ORDER BY obj.id DESC")
    Page<HistoricExtractDTO> findHistoricExtractMovimentationDay(
            LocalDate min, LocalDate max, Pageable pageable);
}
