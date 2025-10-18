package br.com.minhaclinica.model;

public class Funcionario {

    private String nome;
    private int idade;
    private double salario;

    public Funcionario(){

    }

    public Funcionario(String nome, int idade, double salario) {
        this.nome = nome;
        this.idade = idade;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }
    /**
    *@param nome O nome ( não pode ser nulo ou vazio).
    *@throws IllegalArgumentException Se o nome for inválido.
    */
    public void setNome(String nome) {
      if (nome !=null && !nome.trim().isBlank()){
          this.nome = nome;
      } else {
          throw new IllegalArgumentException("Nome não pode ser nulo ou vazio");
      }

    }

    public int getIdade() {
        return idade;
    }
    /**
     * @param idade A idade (deve ser > 0).
     * @throws IllegalArgumentException Se a idade for inválida.
     */
    public void setIdade(int idade) {
        if (idade > 0){
            this.idade =idade;
        }
        else {
            throw new IllegalArgumentException("A idade deve ser um valor positivo");

        }
    }

    public double getSalario() {
        return salario;
    }
    /**
     * @param salario O salário (deve ser >= 0).
     * @throws IllegalArgumentException Se o salário for inválido.
     */
    public void setSalario(double salario) {
        if (salario >= 0.0){
        this.salario = salario;
    } else {
        throw new IllegalArgumentException(" O salário não pode ser negativo");
    }
}
@Override
public String toString(){
    return String.format("Funcionario[Nome: %s, Idade: %d, Salário: R$ %2.f]",
    this.nome, this.idade, this.salario);
    }
}

