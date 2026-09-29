package application;

import model.entities.AluguelDoCarro;
import model.entities.Fatura;
import model.entities.Veiculo;
import model.services.BrazilTaxService;
import model.services.RentalService;

import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Coloque os dados do aluguel do carro:");
        System.out.print("Modelo do carro: ");
        String modelo = sc.nextLine();
        System.out.print("Data de aluguel (dd/MM/yyyy HH:mm): ");
        LocalDateTime dataAluguel = LocalDateTime.parse(sc.nextLine(), java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        System.out.print("Data de devolução (dd/MM/yyyy HH:mm): ");
        LocalDateTime dataDevolucao = LocalDateTime.parse(sc.nextLine(), java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));

        AluguelDoCarro aluguel = new AluguelDoCarro(dataAluguel, dataDevolucao, new Veiculo(modelo), null);

        System.out.println("Digite o preço por hora: ");
        double precoPorHora = sc.nextDouble();
        System.out.println("Digite o preço por dia: ");
        double precoPorDia = sc.nextDouble();
        sc.nextLine(); // Consumir a quebra de linha

        RentalService rentalService = new RentalService(precoPorHora, precoPorDia, new BrazilTaxService());

        rentalService.processInvoice(aluguel);
        Fatura fatura = aluguel.getFatura();

        System.out.println("Fatura:");
        System.out.println("Pagamento básico: " + fatura.getPagamentoBasico());
        System.out.println("Imposto: " + fatura.getImposto());
        System.out.println("Pagamento total: " + fatura.calcularTotalPagamento());

        sc.close();
    }
}
