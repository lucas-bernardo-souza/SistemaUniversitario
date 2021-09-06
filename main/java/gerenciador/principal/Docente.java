/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciador.principal;

/**
 *
 * @author Lucas Bernardo
 */
public abstract class Docente extends Funcionario{
    protected String titulacao;

    public Docente(String codigo, String nome, double salario, String nivel, String titulacao, String tipo) {
            super(codigo, nome, salario, nivel, tipo);
            this.titulacao = titulacao;
    }

    @Override
    public abstract double calcularSalario();

    public String getTitulacao() {
            return titulacao;
    }
}
