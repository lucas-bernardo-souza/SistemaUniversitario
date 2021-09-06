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
public abstract class Funcionario {

    protected String codigo;
    protected String nome;
    protected double salario;
    protected String nivel;
    protected String tipo;

    public Funcionario(String codigo, String nome, double salario, String nivel, String tipo) {
        this.codigo = codigo;
        this.nome = nome;
        this.salario = salario;
        this.nivel = nivel;
        this.tipo = tipo;
    }

    public abstract double calcularSalario();

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getNivel() {
        return nivel;
    }

    public String getTipo() {
        return tipo;
    }
    
    @Override
    public String toString(){
        String sal = Double.toString(salario);
        String fun = codigo + " - " + nome + " - " + nivel + " - " + sal + "\n";
        return fun;
    }
}
