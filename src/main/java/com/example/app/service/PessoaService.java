package com.example.app.service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.stereotype.Service;

import com.example.app.dto.PedidoCreditoDTO;
import com.example.app.entity.Pessoa;

@Service
public class PessoaService {
    
    public Pessoa parsePessoa(PedidoCreditoDTO dto) {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(dto.getNome());
        pessoa.setCpf(dto.getCpf());
        
        LocalDate dataConvertida = Instant.ofEpochMilli(dto.getDataNascimento().getTime())
                                    .atZone(ZoneId.systemDefault()).toLocalDate();
        
        pessoa.setDataNascimento(dataConvertida);
        pessoa.setRendaMensal(dto.getRendaMensal());
        return pessoa;
    }
    
}
