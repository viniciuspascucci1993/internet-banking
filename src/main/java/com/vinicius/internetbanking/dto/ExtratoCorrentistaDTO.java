package com.vinicius.internetbanking.dto;

import com.vinicius.internetbanking.entities.Correntista;
import com.vinicius.internetbanking.entities.ExtratoCorrentista;

public class ExtratoCorrentistaDTO {

    private Long id;
    private Correntista correntista;
    private String descricao;

    public ExtratoCorrentistaDTO() { }

    public ExtratoCorrentistaDTO(ExtratoCorrentista entities) {
        this.id = entities.getId();
        this.correntista = entities.getCorrentista();
        this.descricao = entities.getDescricao();
    }

    public Long getId() {
        return id;
    }

    public Correntista getCorrentista() {
        return correntista;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCorrentista(Correntista correntista) {
        this.correntista = correntista;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
