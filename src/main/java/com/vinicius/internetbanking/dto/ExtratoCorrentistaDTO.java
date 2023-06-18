package com.vinicius.internetbanking.dto;

import com.vinicius.internetbanking.entities.Correntista;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExtratoCorrentistaDTO {

    private Long id;
    private Correntista correntista;
    private String descricao;

}
