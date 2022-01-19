package com.example.app.dto;

import java.util.Date;

import lombok.Data;

@Data
public class PedidoCreditoDTO {
    private String nome;
    private String cpf;
    private Date dataNascimento;
    private Double rendaMensal;
    private Double valorRequerido;
}
