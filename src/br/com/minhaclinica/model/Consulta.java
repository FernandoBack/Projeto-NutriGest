package br.com.minhaclinica.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;


public class Consulta {

    private final Nutricionista nutricionista;
    private final String nomePaciente;
    private final LocalDateTime dataHora;


    private static final DateTimeFormatter FORMATADOR_DATA_HORA =
            DateTimeFormatter.ofPattern("dd/MM/yyyy 'às' HH:mm");



    public Consulta(Nutricionista nutricionista, String nomePaciente, LocalDateTime dataHora) {

        this.nutricionista = Objects.requireNonNull(nutricionista, "O nutricionista não pode ser nulo.");
        this.dataHora = Objects.requireNonNull(dataHora, "A data e hora não podem ser nulos.");

        if (nomePaciente == null || nomePaciente.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do paciente não pode ser nulo ou vazio.");
        }
        this.nomePaciente = nomePaciente;
    }



    public Nutricionista getNutricionista() {
        return nutricionista;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }


    public String getDataHoraFormatada() {
        return this.dataHora.format(FORMATADOR_DATA_HORA);
    }


    @Override
    public String toString() {
        return String.format(
                "Consulta[Paciente: %s, Nutricionista: %s, Data: %s]",
                this.nomePaciente,
                this.nutricionista.getNome(),
                this.getDataHoraFormatada()
        );
    }
}