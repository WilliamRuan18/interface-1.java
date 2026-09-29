package model.entities;

import java.time.Duration;
import java.time.LocalDateTime;

public class Fatura {
    private double pagamentoBasico;
    private double imposto;
    private double totalPagamento;

    public Fatura() {
    }

    public Fatura(double pagamentoBasico, double imposto) {
        this.pagamentoBasico = pagamentoBasico;
        this.imposto = imposto;
        this.totalPagamento = calcularTotalPagamento();
    }

    public double getPagamentoBasico() {
        return pagamentoBasico;
    }

    public void setPagamentoBasico(double pagamentoBasico) {
        this.pagamentoBasico = pagamentoBasico;
    }

    public double getImposto() {
        return imposto;
    }

    public void setImposto(double imposto) {
        this.imposto = imposto;
    }

    public double getTotalPagamento() {
        return totalPagamento;
    }

    public void setTotalPagamento(double totalPagamento) {
        this.totalPagamento = totalPagamento;
    }

    public Double calcularTotalPagamento() {
        return getPagamentoBasico() + getImposto();
    }


}
