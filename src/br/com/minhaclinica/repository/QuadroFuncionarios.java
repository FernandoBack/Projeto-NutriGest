package br.com.minhaclinica.repository;

import br.com.minhaclinica.model.Funcionario;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


public final class QuadroFuncionarios {


    private static final List<Funcionario> ListaFuncionarios = new ArrayList<>();


    private QuadroFuncionarios() {

    }

    /**
     * @param funcionario O funcionário a ser contratado (não pode ser nulo).
     * @throws NullPointerException se o funcionário for nulo.
     */
    public static void contratar(Funcionario funcionario) {
        Objects.requireNonNull(funcionario, "Não é possível contratar um funcionário nulo.");


        ListaFuncionarios.add(funcionario);
        System.out.println(funcionario.getNome() + " foi contratado(a).");
    }

    /**
     * @return Uma lista (List<Funcionario>) que não pode ser alterada.
     */
    public static List<Funcionario> getListaFuncionarios() {
        return Collections.unmodifiableList(ListaFuncionarios);
    }
}