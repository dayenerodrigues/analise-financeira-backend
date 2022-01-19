package com.example.app.entity;

public enum Situacao {
    APROVADO("A"),
    EM_ANALISE("E"),
    REPROVADO("R");

    String codigo;
    
    Situacao(String codigo) {
        this.codigo = codigo;
    }
}
