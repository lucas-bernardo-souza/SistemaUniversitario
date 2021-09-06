/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciador.Controlador;

import gerenciador.principal.Departamento;
import gerenciador.principal.Funcionario;
import gerenciador.principal.Universidade;
import java.util.ArrayList;

/**
 *
 * @author Lucas Bernardo
 */
public class Controlador {

    private Universidade universidade = Universidade.getInstance();
    private static boolean instanciada = false;
    private static boolean instanciadaDep = false;

    public void InicializaUniversidade(String nome) {
        universidade.setNome(nome);
        instanciada = true;
    }

    public Universidade buscarUni(String nome) {
        if (instanciada == false) {
            return null;
        } else if (universidade.getNome().equals(nome)) {
            return universidade;
        } else {
            return null;
        }
    }

    public String getNomeUni() {
        return universidade.getNome();
    }

    public int getMaxUni() {
        return universidade.getMax();
    }

    public int getContUni() {
        return universidade.getCont();
    }

    public void addDepartamento(String codigo, String nome, int dim) {
        universidade.addDepartamento(codigo, nome, dim);
        instanciadaDep = true;
    }

    public void addTecnico(String codigo, String nome, double salario, String nivel, String funcao, String nomeDep) {
        universidade.addTecnico(codigo, nome, salario, nivel, funcao, nomeDep);
    }

    public void addDocenteEfetivo(String codigo, String nome, double salario, String nivel, String titulacao, String area, String nomeDep) {
        universidade.addDocenteEfetivo(codigo, nome, salario, nivel, titulacao, area, nomeDep);
    }

    public void addDocenteSubstituto(String codigo, String nome, double salario, String nivel, String titulacao, int cargaHoraria, String nomeDep) {
        universidade.addDocenteSubstituto(codigo, nome, salario, nivel, titulacao, cargaHoraria, nomeDep);
    }

    public Departamento buscaDepCod(String codigo) {
        Departamento d = universidade.buscaDepCodigo(codigo);
        return d;
    }

    public Departamento buscaDepNome(String nome) {
        return universidade.buscaDepNome(nome);
    }

    public boolean getInstanciada() {
        return instanciada;
    }

    public boolean getInstanciadaDep() {
        return instanciadaDep;
    }

    public boolean espacoLivreDep(String nome) {
        return universidade.espacoDispDep(nome);
    }

    public Funcionario buscaFuncionarioCod(String codigo, String nomeDep) {
        return universidade.buscaFuncionarioCod(codigo, nomeDep);
    }

    public Funcionario buscaFuncionarioNome(String nome, String nomeDep) {
        return universidade.buscaFuncionarioNome(nome, nomeDep);
    }

    public String[] nomesFuncionarios(String nomeDep) {
        return universidade.nomesFuncionarios(nomeDep);
    }

    public String[] nomesDepartamentos() {
        return universidade.nomesDepartamentos();
    }

    public double gastosTotalDep(String nome) {
        return universidade.gastosTotalDep(nome);
    }

    public String[] funcionarios() {
        return universidade.funcionarios();
    }

    public String[] tecnicos() {
        return universidade.tecnicos();
    }

    public String[] docentes() {
        return universidade.docentes();
    }

    public String[] docentesEfetivos() {
        return universidade.docentesEfetivos();
    }

    public String[] docentesSubstitutos() {
        return universidade.docentesSubstitutos();
    }

    public String[] funcionariosComFaixaDeSal(double minimo, double max) {
        return universidade.funcionariosComFaixaDeSal(minimo, max);
    }

    public String[] resumoDepartamentosNaFaixa(double minimo, double max) {
        return universidade.resumoDepartamentosNaFaixa(minimo, max);
    }

    public String[] resumoDepartamento() {
        return universidade.resumoDepartamento();
    }
    
    public String[] geral(){
        return universidade.geral();
    }
}
