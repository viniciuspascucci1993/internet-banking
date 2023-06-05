package com.vinicius.internetbanking.repositories;

import com.vinicius.internetbanking.entities.Correntista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorrentistaRepository extends JpaRepository<Correntista, Long> {
}
