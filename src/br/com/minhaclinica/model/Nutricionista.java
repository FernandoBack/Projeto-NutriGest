package br.com.minhaclinica.model;


    public class Nutricionista extends Funcionario{

        private int numeroConsulta;

        public Nutricionista(){
            super();
            this.numeroConsulta = 0;

        }
        public Nutricionista(String nome, int idade, double salario, int numeroConsulta){
            super (nome, idade, salario);
            this.setNumeroConsulta(numeroConsulta);
        }

        public int getNumeroConsulta() {
            return numeroConsulta;
        }
        /**
         * @param numeroConsulta O número (deve ser >= 0).
         * @throws IllegalArgumentException Se o número for inválido.
         */
        public void setNumeroConsulta(int numeroConsulta) {
            if (numeroConsulta >= 0){
            } else {
                throw new IllegalArgumentException("O número de consulta não pode ser negativo");
            }
        }
        @Override
        public String toString(){
            String infoFuncionario = super.toString().replace("]", "");
            return String.format("%s, Consultas: %d]",
            infoFuncionario, this.numeroConsulta);
        }
    }

