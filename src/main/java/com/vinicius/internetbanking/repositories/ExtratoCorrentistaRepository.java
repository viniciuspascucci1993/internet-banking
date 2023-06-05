package com.vinicius.internetbanking.repositories;

import com.vinicius.internetbanking.entities.ExtratoCorrentista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExtratoCorrentistaRepository extends JpaRepository<ExtratoCorrentista, Long> {
}
