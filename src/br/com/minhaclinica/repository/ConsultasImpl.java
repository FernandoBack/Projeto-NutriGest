package br.com.minhaclinica.repository;

import br.com.minhaclinica.model.Consulta;
import br.com.minhaclinica.model.Nutricionista;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


public final class ConsultasImpl implements IConsultaManager {


    private static final ConsultasImpl instance = new ConsultasImpl();


    public static ConsultasImpl getInstance() {
        return instance;
    }


    private final List<Consulta> ListaConsultas;


    private ConsultasImpl() {
        this.ListaConsultas = new ArrayList<>();
    }


    @Override
    public void AdicionaConsulta(Consulta consulta) {
        Objects.requireNonNull(consulta, "Não é possível agendar uma consulta nula.");


        this.ListaConsultas.add(consulta);


        Nutricionista nutriResponsavel = consulta.getNutricionista();
        int consultasAtuais = nutriResponsavel.getNumeroConsulta();
        nutriResponsavel.setNumeroConsulta(consultasAtuais + 1);

        System.out.println("Consulta agendada para " + consulta.getNomePaciente() +
                " em " + consulta.getDataHoraFormatada());
    }


    @Override
    public List<Consulta> RetornaConsultas() {

        return Collections.unmodifiableList(this.ListaConsultas);
    }


    @Override
    public void DeletaConsulta(int posicao) {
        try {

            Consulta consultaRemovida = this.ListaConsultas.remove(posicao);


            Nutricionista nutri = consultaRemovida.getNutricionista();


            if (nutri.getNumeroConsulta() > 0) {
                nutri.setNumeroConsulta(nutri.getNumeroConsulta() - 1);
            }

            System.out.println("Consulta de " + consultaRemovida.getNomePaciente() + " foi removida com sucesso.");

        } catch (IndexOutOfBoundsException e) {

            System.err.println("Erro ao deletar: Posição inválida: " + posicao);
            System.err.println("A lista tem " + this.ListaConsultas.size() + " itens (índices de 0 a " + (this.ListaConsultas.size() - 1) + ").");

        } catch (Exception e) {

            System.err.println("Um erro inesperado ocorreu ao deletar a consulta: " + e.getMessage());
        }
    }
}