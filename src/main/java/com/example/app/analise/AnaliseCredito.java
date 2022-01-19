package com.example.app.analise;

import java.math.BigDecimal;

import com.example.app.entity.Situacao;

public abstract class AnaliseCredito {
    private static final BigDecimal SALARIO_MINIMO = BigDecimal.valueOf(1200);

    protected abstract Integer getReferenciaRendaMinima();
    protected abstract Integer getReferenciaRendaAprovada();
    protected abstract Integer getTaxaJuros();
    
    public Situacao analisaCredito(Double rendaMensal) {
        if (!rendaMaiorQueReferenciaSalarioMinimo(rendaMensal, getReferenciaRendaMinima())) {
              return Situacao.REPROVADO;
          }
          
          if (rendaMaiorQueReferenciaSalarioMinimo(rendaMensal, getReferenciaRendaAprovada())) {
              return Situacao.APROVADO;
          }
          
          return Situacao.EM_ANALISE;
    }
    
    private boolean rendaMaiorQueReferenciaSalarioMinimo(Double rendaMensal, Integer referencia) {
        return BigDecimal.valueOf(rendaMensal).compareTo(SALARIO_MINIMO.multiply(BigDecimal.valueOf(referencia))) > 0;
    }
    
    private BigDecimal getPercentualJuros() {
        return BigDecimal.valueOf(getTaxaJuros()).divide(BigDecimal.valueOf(100D));
    }

    public Double calculaValorCredito(Double valorRequerido) {
        return BigDecimal.valueOf(valorRequerido).multiply(getPercentualJuros()).doubleValue();
    }
}
