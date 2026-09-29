package model.entities;

import java.time.LocalDateTime;

public class AluguelDoCarro {
    private static LocalDateTime dataDeAluguel;
    private static LocalDateTime dataDeDevolucao;

    private Veiculo veiculo;
    private Fatura fatura;

    public AluguelDoCarro() {
    }

    public AluguelDoCarro(LocalDateTime dataDeAluguel, LocalDateTime dataDeDevolucao, Veiculo veiculo, Fatura fatura) {
        this.dataDeAluguel = dataDeAluguel;
        this.dataDeDevolucao = dataDeDevolucao;
        this.veiculo = veiculo;
        this.fatura = fatura;
    }

    public static LocalDateTime getDataDeAluguel() {
        return dataDeAluguel;
    }

    public static void setDataDeAluguel(LocalDateTime dataDeAluguel) {
        AluguelDoCarro.dataDeAluguel = dataDeAluguel;
    }

    public static LocalDateTime getDataDeDevolucao() {
        return dataDeDevolucao;
    }

    public static void setDataDeDevolucao(LocalDateTime dataDeDevolucao) {
        AluguelDoCarro.dataDeDevolucao = dataDeDevolucao;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Fatura getFatura() {
        return fatura;
    }

    public void setFatura(Fatura fatura) {
        this.fatura = fatura;
    }

}
