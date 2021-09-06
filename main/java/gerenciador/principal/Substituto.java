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
public class Substituto extends Docente{
    private int cargaHoraria;

    public Substituto(String codigo, String nome, double salario, String nivel, String titulacao, int cargaHoraria, String tipo) {
            super(codigo, nome, salario, nivel, titulacao, tipo);
            this.cargaHoraria = cargaHoraria;
            calcularSalario();
    }

    @Override
    public double calcularSalario() {
            if(nivel.equals("S1"))
                    return (salario += salario * 0.05);
            else
                    return (salario += salario * 0.1);
    }

    public int getCargaHoraria() {
            return cargaHoraria;
    }
}
