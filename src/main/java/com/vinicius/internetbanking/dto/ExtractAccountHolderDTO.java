package com.vinicius.internetbanking.dto;

import com.vinicius.internetbanking.entities.AccountHolder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExtractAccountHolderDTO {

    private Long id;
    private AccountHolder correntista;
    private String descricao;

}
