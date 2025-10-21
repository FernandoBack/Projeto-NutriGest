# NutriGest - Sistema de Gestão para Clínica de Nutrição

![Java](https://img.shields.io/badge/Java-17%2B-blue?logo=java&logoColor=white)
![Git](https://img.shields.io/badge/Git-F05032?logo=git&logoColor=white)

Este projeto é um sistema de back-end em Java para o gerenciamento de uma clínica de nutrição. Ele permite o cadastro de funcionários, o gerenciamento de nutricionistas (como um tipo especial de funcionário) e o agendamento de consultas.

O foco principal do projeto não é a interface, mas a **construção de um back-end robusto**, utilizando os pilares da Programação Orientada a Objetos e Padrões de Design para garantir um código limpo, manutenível e extensível.

## 🚀 Conceitos e Padrões Aplicados

Este projeto foi construído como um exercício de arquitetura de software, demonstrando:

* **Encapsulamento:** Todos os atributos das classes de modelo (como `Funcionario`, `Nutricionista` e `Consulta`) são `private`. O acesso é mediado por `getters` e `setters`.
* **Validação (Fail-Fast):** Os `setters` e construtores utilizam exceções (ex: `IllegalArgumentException`) para validar dados na entrada. Isso impede que objetos sejam criados em um estado inválido (ex: um funcionário com salário negativo).
* **Herança:** A classe `Nutricionista` estende `Funcionario`, reutilizando código e estabelecendo uma relação "é-um".
* **Composição:** A classe `Consulta` *tem-um* `Nutricionista`, demonstrando a relação "tem-um".
* **Imutabilidade:** A classe `Consulta` é imutável (atributos `final` e sem `setters`), garantindo que um registro de consulta, uma vez criado, não possa ser alterado.
* **Desacoplamento (Interfaces):** Foi criada a interface `IConsultaManager` para definir o *contrato* de gerenciamento de consultas. A classe `Main` depende desta interface, não da implementação concreta.
* **Padrão de Projeto (Singleton):** A classe `ConsultasImpl` implementa o padrão Singleton para garantir que exista apenas *uma instância* do repositório de consultas em toda a aplicação.
* **API `java.time`:** Uso de `LocalDateTime` para o gerenciamento moderno de datas e horas.

## 📂 Estrutura de Pacotes

O projeto segue uma arquitetura baseada em camadas, separando responsabilidades:

src └── br └── com └── minhaclinica ├── model (As "Entidades" do negócio) │ ├── Consulta.java │ ├── Funcionario.java │ └── Nutricionista.java │ ├── repository (Classes de acesso a dados) │ ├── ConsultasImpl.java │ ├── IConsultaManager.java │ └── QuadroFuncionarios.java │ └── Main.java (Ponto de entrada da aplicação)

## ⚙️ Como Executar

1.  Clone este repositório:
    ```bash
    git clone [URL-DO-REPOSITORIO]
    ```
2.  Abra o projeto em sua IDE Java preferida (ex: IntelliJ IDEA ou Eclipse).
3.  A IDE irá carregar as dependências (neste caso, apenas o JDK).
4.  Encontre e execute o método `main` na classe `src/br/com/minhaclinica/Main.java`.
5.  O output da simulação será exibido no console.
