package br.com.minhaclinica;


import br.com.minhaclinica.model.Consulta;
import br.com.minhaclinica.model.Funcionario;
import br.com.minhaclinica.model.Nutricionista;
import br.com.minhaclinica.repository.ConsultasImpl;
import br.com.minhaclinica.repository.IConsultaManager;
import br.com.minhaclinica.repository.QuadroFuncionarios;


import java.time.LocalDateTime;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        System.out.println("=== INICIANDO SISTEMA DA CLÍNICA DE NUTRIÇÃO ===");

        try {

            System.out.println("\n[ETAPA 1: CRIAÇÃO DE OBJETOS]");


            Funcionario recepcionista = new Funcionario("Carlos Andrade", 28, 2800.00);


            Nutricionista draElisa = new Nutricionista("Dra. Elisa Mendes", 34, 6500.00, 0);

            // 1.3 Consultas
            LocalDateTime data1 = LocalDateTime.of(2024, 10, 20, 9, 0);
            LocalDateTime data2 = LocalDateTime.of(2024, 10, 20, 10, 30);
            LocalDateTime data3 = LocalDateTime.of(2024, 10, 21, 14, 0);

            Consulta consulta1 = new Consulta(draElisa, "João Pedro", data1);
            Consulta consulta2 = new Consulta(draElisa, "Maria Silva", data2);
            Consulta consulta3 = new Consulta(draElisa, "Roberto Gomes", data3);

            System.out.println("Objetos criados com sucesso.");


            System.out.println("\n[ETAPA 2: PROCESSAMENTO E GERENCIAMENTO DE DADOS]");


            QuadroFuncionarios.contratar(recepcionista);
            QuadroFuncionarios.contratar(draElisa);


            IConsultaManager managerConsultas = ConsultasImpl.getInstance();



            managerConsultas.AdicionaConsulta(consulta1);
            managerConsultas.AdicionaConsulta(consulta2);
            managerConsultas.AdicionaConsulta(consulta3);

            System.out.println("Dados processados e armazenados.");



            System.out.println("\n===== RELATÓRIO DE CONSULTAS AGENDADAS =====");
            List<Consulta> todasConsultas = managerConsultas.RetornaConsultas();

            if (todasConsultas.isEmpty()) {
                System.out.println("Nenhuma consulta agendada no momento.");
            } else {

                for (Consulta c : todasConsultas) {
                    System.out.println(c.toString());
                }
            }


            System.out.println("\n===== RELATÓRIO DE FUNCIONÁRIOS =====");
            List<Funcionario> todosFuncionarios = QuadroFuncionarios.getListaFuncionarios();

            if (todosFuncionarios.isEmpty()) {
                System.out.println("Nenhum funcionário contratado.");
            } else {
                for (Funcionario func : todosFuncionarios) {



                    String cargo;
                    if (func instanceof Nutricionista) {
                        cargo = "Nutricionista";
                    } else {
                        cargo = "Funcionário Geral";
                    }


                    System.out.printf("Nome: %-20s | Salário: R$ %8.2f | Cargo: %s\n",
                            func.getNome(),
                            func.getSalario(),
                            cargo);
                }
            }


            System.out.println("\n[VERIFICAÇÃO DE ESTADO]");
            System.out.println("Status final " + draElisa.getNome() + ": " + draElisa.getNumeroConsulta() + " consultas registradas.");


        } catch (IllegalArgumentException | NullPointerException e) {

            System.err.println("\n!!! ERRO CRÍTICO AO PROCESSAR DADOS !!!");
            System.err.println("Mensagem: " + e.getMessage());
            e.printStackTrace();
        }

        System.out.println("\n=== SISTEMA ENCERRADO ===");
    }
}