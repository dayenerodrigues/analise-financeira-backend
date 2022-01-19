package com.example.app.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.example.app.analise.AnaliseCredito;
import com.example.app.analise.AnaliseCreditoAte25Anos;
import com.example.app.analise.AnaliseCreditoAte40Anos;
import com.example.app.analise.AnaliseCreditoMaisDe40Anos;
import com.example.app.entity.Pedido;
import com.example.app.entity.Pessoa;
import com.example.app.entity.Situacao;

@Service
public class PedidoService {
    
    public AnaliseCredito getAnaliseCredito(Pessoa requerente) {
        if (calculaIdadeAnaliseCredito(requerente.getDataNascimento(), 25)) {
            return new AnaliseCreditoAte25Anos();
        } 
        
        if (calculaIdadeAnaliseCredito(requerente.getDataNascimento(), 40)) {
            return new AnaliseCreditoAte40Anos();
        }
        
        return new AnaliseCreditoMaisDe40Anos();
    }
    
    private boolean calculaIdadeAnaliseCredito(LocalDate dataNascimento, Integer limite) {
        LocalDate dataAtual = LocalDate.now();
        return dataAtual.getYear() - dataNascimento.getYear() <= limite;
    }

    public Pedido realizaPedidoEmprestimo(Pessoa pessoa, Double valorRequerido) {
        AnaliseCredito analiseCredito = getAnaliseCredito(pessoa);
        Pedido pedido = new Pedido();
        pedido.setRequerente(pessoa);
        pedido.setValorRequerido(valorRequerido);
        pedido.setSituacao(analiseCredito.analisaCredito(pessoa.getRendaMensal()));
        
        if (!Situacao.REPROVADO.equals(pedido.getSituacao())) {
            pedido.setValorJuros(analiseCredito.calculaValorCredito(pedido.getValorRequerido()));
        }
        
        return pedido;
    }
    
}
