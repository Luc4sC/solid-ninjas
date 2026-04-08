package estacionamento;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    private static DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    static void main() {
        Veiculo veiculo = new Veiculo("ELR2F39", "Fiat Palio", "Carro");
        Ticket ticket = new Ticket(veiculo, LocalDateTime.now());

        System.out.println("--- Entrada Registrada ---");
        System.out.println("Placa: " + ticket.getVeiculo().getPlaca() + " | Modelo: " + ticket.getVeiculo().getModelo()
        + " | Entrada: " + ticket.getHorarioEntrada().format(formatador));


        ticket.setHorarioSaida(LocalDateTime.now().plusHours(3));
        double baseCalculo = 0;
        if (veiculo.getTipo() == "Carro") {
            baseCalculo = 10.0;
        } else {
            baseCalculo = 5.0;
        }
        double preco = (Duration.between(ticket.getHorarioEntrada(), ticket.getHorarioSaida()).toHours()) *
                baseCalculo;

        System.out.println("");
        System.out.println("--- Saída Finalizada ---");
        System.out.println("Veículo: " + veiculo.getPlaca());
        System.out.println("Permanência: " + Duration.between(ticket.getHorarioEntrada(),
                ticket.getHorarioSaida()).toHours() + " horas");
        System.out.println("Valor Total: " + preco + "(Tarifa: " + veiculo.getTipo() + ")");
    }

}
