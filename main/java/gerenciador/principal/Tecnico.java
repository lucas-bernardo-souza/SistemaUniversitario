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
public class Tecnico extends Funcionario {
    private String funcao;

    public Tecnico(String codigo, String nome, double salario, String nivel, String funcao, String tipo) {
	super(codigo, nome, salario, nivel, tipo);
	this.funcao = funcao;
        calcularSalario();
    }
	
    @Override
    public double calcularSalario() {
        if(nivel.equals("T1")) {
            return salario += salario * 0.1;
        }
        else
            return salario += salario * 0.2;
    }

    public String getFuncao() {
            return funcao;
    }
}
