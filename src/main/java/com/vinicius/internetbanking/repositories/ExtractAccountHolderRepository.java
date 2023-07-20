package com.vinicius.internetbanking.repositories;

import com.vinicius.internetbanking.entities.ExtractAccountHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

public interface ExtractAccountHolderRepository extends JpaRepository<ExtractAccountHolder, Long> {
}
