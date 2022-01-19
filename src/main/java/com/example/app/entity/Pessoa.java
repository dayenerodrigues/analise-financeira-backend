package com.example.app.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="pessoa")
@Data
public class Pessoa implements Serializable {
    private static final long serialVersionUID = -9098151060983539795L;
    
    @Id @GeneratedValue
    private Long id;
    
    @Column
    private String nome;
    
    @Column
    private String cpf;
    
    @Column
    private LocalDate dataNascimento;
    
    @Column
    private Double rendaMensal;
}
