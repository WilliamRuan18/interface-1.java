package model.services;

import model.entities.AluguelDoCarro;
import model.entities.Fatura;

import java.time.Duration;

public class RentalService {
    private double precoPorHora;
    private double precoPorDia;

    private TaxService taxService;

    public RentalService(double precoPorHora, double precoPorDia, TaxService taxService) {
        this.precoPorHora = precoPorHora;
        this.precoPorDia = precoPorDia;
        this.taxService = taxService;
    }

    public void processInvoice(AluguelDoCarro aluguelCarro) {
        double Minutos = Duration.between(AluguelDoCarro.getDataDeAluguel(), AluguelDoCarro.getDataDeDevolucao()).toMinutes();
        double horas = Minutos / 60.0;

        double pagamentoBasico;
        if (horas <= 12.0) {
            pagamentoBasico = Math.ceil(horas) * precoPorHora;
        } else {
           pagamentoBasico = Math.ceil(horas / 24.0) * precoPorDia;
        }
        double imposto = taxService.tax(pagamentoBasico);
        aluguelCarro.setFatura(new Fatura(pagamentoBasico, imposto));

    }
}
