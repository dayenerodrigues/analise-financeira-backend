package com.example.app.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="pedido")
@Data
public class Pedido implements Serializable {
    private static final long serialVersionUID = 1411963519425362999L;
    
    @Id @GeneratedValue
    private Long id;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "requerente_id", referencedColumnName = "id")
    private Pessoa requerente;
    
    @Column
    private Double valorRequerido;
    
    @Column
    private Double valorJuros;
    
    @Column
    private Situacao situacao;
}
