package br.com.minhaclinica.repository;

import br.com.minhaclinica.model.Consulta;
import java.util.List;


public interface IConsultaManager {

    /**
     * @param consulta A consulta a ser adicionada.
     */
    void AdicionaConsulta(Consulta consulta);

    /**
     * @return Uma List<Consulta> (preferencialmente não modificável).
     */
    List<Consulta> RetornaConsultas();

    /**
     * @param posicao O índice (baseado em 0) da consulta a ser removida.
     */
    void DeletaConsulta(int posicao);
}