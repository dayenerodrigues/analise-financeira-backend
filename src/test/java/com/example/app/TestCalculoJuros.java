package com.example.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.app.analise.AnaliseCredito;
import com.example.app.analise.AnaliseCreditoAte25Anos;
import com.example.app.analise.AnaliseCreditoAte40Anos;
import com.example.app.analise.AnaliseCreditoMaisDe40Anos;

class TestCalculoJuros {
    private AnaliseCredito analiseCredito;
    Double valorRequerido = Double.valueOf(20000);
    
    @Test
    void testJuros25Anos() {
        analiseCredito = new AnaliseCreditoAte25Anos();
        assertEquals(Double.valueOf(5000), analiseCredito.calculaValorCredito(valorRequerido));
    }
    
    @Test
    void testJuros40Anos() {
        analiseCredito = new AnaliseCreditoAte40Anos();
        assertEquals(Double.valueOf(4000), analiseCredito.calculaValorCredito(valorRequerido));
    }
    
    @Test
    void testJuros60Anos() {
        analiseCredito = new AnaliseCreditoMaisDe40Anos();
        assertEquals(Double.valueOf(3000), analiseCredito.calculaValorCredito(valorRequerido));
    }

}
