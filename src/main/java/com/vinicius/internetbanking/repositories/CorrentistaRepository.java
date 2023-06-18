package com.vinicius.internetbanking.repositories;

import com.vinicius.internetbanking.entities.AccountHolder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorrentistaRepository extends JpaRepository<AccountHolder, Long> {
}
