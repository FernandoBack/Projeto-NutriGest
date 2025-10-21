package br.com.minhaclinica.repository;

import br.com.minhaclinica.model.Consulta;
import br.com.minhaclinica.model.Nutricionista;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


public final class ConsultasImpl {


    private static final List<Consulta> ListaConsultas = new ArrayList<>();


    private ConsultasImpl() {

    }

    /**
     * @param consulta A consulta a ser agendada (não pode ser nula).
     * @throws NullPointerException se a consulta for nula.
     */
    public static void agendar(Consulta consulta) {
        Objects.requireNonNull(consulta, "Não é possível agendar uma consulta nula.");

        // Adiciona a consulta à lista geral
        ListaConsultas.add(consulta);


        Nutricionista nutriResponsavel = consulta.getNutricionista();
        int consultasAtuais = nutriResponsavel.getNumeroConsultas();
        nutriResponsavel.setNumeroConsultas(consultasAtuais + 1);

        System.out.println("Consulta agendada para " + consulta.getNomePaciente() +
                " em " + consulta.getDataHoraFormatada());
    }

    /**
     * @return Uma lista (List<Consulta>) que não pode ser alterada.
     */
    public static List<Consulta> getListaConsultas() {
        return Collections.unmodifiableList(ListaConsultas);
    }
}