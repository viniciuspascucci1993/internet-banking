package com.vinicius.internetbanking.dto;

import com.vinicius.internetbanking.entities.AccountHolder;
import com.vinicius.internetbanking.entities.ExtractAccountHolder;
import com.vinicius.internetbanking.entities.HistoricExtract;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExtractAccountHolderDTO {

    private Long idExtractAccountHolder;
    private AccountHolder accountHolder;
    private List<HistoricExtract> historicExtract;
    private String description;

    public ExtractAccountHolderDTO(ExtractAccountHolder entitie) {
        this.idExtractAccountHolder = entitie.getIdExtractAccountHolder();
        this.accountHolder = entitie.getAccountHolder();
        this.historicExtract = entitie.getHistoricExtractList();
        this.description = entitie.getDescription();
    }
}
