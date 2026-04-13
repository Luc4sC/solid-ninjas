package estacionamento;

import java.time.LocalDateTime;

public class Ticket {

    private final Veiculo veiculo;
    private final LocalDateTime horarioEntrada;
    private LocalDateTime horarioSaida;

    public Ticket(Veiculo veiculo, LocalDateTime horarioEntrada) {
        this.veiculo = veiculo;
        this.horarioEntrada = horarioEntrada;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public LocalDateTime getHorarioEntrada() {
        return horarioEntrada;
    }

    public LocalDateTime getHorarioSaida() {
        return horarioSaida;
    }

    public void setHorarioSaida(LocalDateTime horarioSaida) {
        this.horarioSaida = horarioSaida;
    }

}
