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
public class Efetivo extends Docente{
    private String area;

    public Efetivo(String codigo, String nome, double salario, String nivel, String titulacao, String area, String tipo) {
            super(codigo, nome, salario, nivel, titulacao, tipo);
            this.area = area;
            calcularSalario();
    }

    @Override
    public double calcularSalario() {
        if(nivel.equals("D1"))
                return (salario += salario * 0.05 + salario * 0.05);
        else if(nivel.equals("D2"))
                return (salario += salario * 0.05 + salario * 0.1);
        else
                return(salario += salario * 0.05 + salario * 0.2);
    }//Além do acréssimo por nível o efetivo tem um acréssimo de 5% ao salário

    public String getArea() {
            return area;
    }
}
