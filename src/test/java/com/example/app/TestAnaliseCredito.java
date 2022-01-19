package com.example.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.app.analise.AnaliseCredito;
import com.example.app.analise.AnaliseCreditoAte25Anos;
import com.example.app.analise.AnaliseCreditoAte40Anos;
import com.example.app.analise.AnaliseCreditoMaisDe40Anos;
import com.example.app.entity.Situacao;

@SpringBootTest
class TestAnaliseCredito {
    private AnaliseCredito analiseCredito;
    Double rendaMensal;
    
    @Test
    void testAnalise25Anos() {
        analiseCredito = new AnaliseCreditoAte25Anos();
        rendaMensal = Double.valueOf(2000);
        assertEquals(Situacao.REPROVADO, analiseCredito.analisaCredito(rendaMensal));
        
        rendaMensal = Double.valueOf(6000);
        assertEquals(Situacao.EM_ANALISE, analiseCredito.analisaCredito(rendaMensal));
        
        rendaMensal = Double.valueOf(7000);
        assertEquals(Situacao.APROVADO, analiseCredito.analisaCredito(rendaMensal));
    }
    
    @Test
    void testAnalise40Anos() {
        analiseCredito = new AnaliseCreditoAte40Anos();
        rendaMensal = Double.valueOf(4000);
        assertEquals(Situacao.REPROVADO, analiseCredito.analisaCredito(rendaMensal));
        
        rendaMensal = Double.valueOf(6000);
        assertEquals(Situacao.EM_ANALISE, analiseCredito.analisaCredito(rendaMensal));
        
        rendaMensal = Double.valueOf(10000);
        assertEquals(Situacao.APROVADO, analiseCredito.analisaCredito(rendaMensal));
    }
    
    @Test
    void testAnalise60Anos() {
        analiseCredito = new AnaliseCreditoMaisDe40Anos();
        rendaMensal = Double.valueOf(7000);
        assertEquals(Situacao.REPROVADO, analiseCredito.analisaCredito(rendaMensal));
        
        rendaMensal = Double.valueOf(10000);
        assertEquals(Situacao.EM_ANALISE, analiseCredito.analisaCredito(rendaMensal));
        
        rendaMensal = Double.valueOf(13000);
        assertEquals(Situacao.APROVADO, analiseCredito.analisaCredito(rendaMensal));
    }

}
