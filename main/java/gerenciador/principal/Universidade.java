/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciador.principal;

import static com.sun.source.util.Trees.instance;
import static java.lang.Integer.max;
import java.util.ArrayList;
import persistencia.DataBase;

/**
 *
 * @author Lucas Bernardo
 */
public class Universidade {
    private static Universidade instance = null;
    private DataBase db = DataBase.getInstance();
    private String nome;
    
    public static Universidade getInstance() {
        if (instance == null) {
            instance = new Universidade();
        }
        return instance;
    }
    
    public Universidade(){
        
    }
    
    public void setNome (String nome) {
        this.nome = nome;
    }

    public void addDepartamento(String codigo, String nome, int dim) {
        Departamento d = new Departamento(codigo, nome, dim);
        db.addDepartamento(d);
    }

    public void addTecnico(String codigo, String nome, double salario, String nivel, String funcao, String nomeDep) {
        Tecnico tecnico = new Tecnico(codigo, nome, salario, nivel, funcao, "T");
        int i = db.buscaPosDep(nomeDep);
        db.addTecnico(tecnico, i);
    }

    public void addDocenteEfetivo(String codigo, String nome, double salario, String nivel, String titulacao, String area, String nomeDep) {
        Efetivo docenteEfetivo = new Efetivo(codigo, nome, salario, nivel, titulacao, area, "E");
        int i = db.buscaPosDep(nomeDep);
        db.addDocenteEfetivo(docenteEfetivo, i);
    }

    public void addDocenteSubstituto(String codigo, String nome, double salario, String nivel, String titulacao, int cargaHoraria, String nomeDep) {
        Substituto docenteSubstituto = new Substituto(codigo, nome, salario, nivel, titulacao, cargaHoraria, "S");
        int i = db.buscaPosDep(nomeDep);
        db.addDocenteSub(docenteSubstituto, i);
    }

    public String getNome() {
        return nome;
    }
    
    public Departamento buscaDepCodigo(String codigo){
        Departamento d = db.buscaDepCodigo(codigo);
        return d;
    }
    
    public Departamento buscaDepNome(String nome){
        return db.buscaDepNome(nome);
    }
    
    public int getMax(){
        return db.getMax();
    }
    
    public int getCont(){
        return db.getCont();
    }
    
    public int buscaPosDep(String nome){
        return db.buscaPosDep(nome);
    }
    
    public boolean espacoDispDep(String nome){
        return db.espacoDispDep(nome);
    }
    
    public Funcionario buscaFuncionarioCod(String codigo, String nomeDep){
        return db.buscaFuncionarioCod(codigo, nomeDep);
    }
    
    public Funcionario buscaFuncionarioNome(String nome, String nomeDep){
        return db.buscaFuncionarioNome(nome, nomeDep);
    }
    
    public String[] nomesFuncionarios(String nomeDep){
        return db.nomesFuncionarios(nomeDep);
    }
    
    public String[] nomesDepartamentos(){
        return db.nomesDepartamentos();
    }
    
    public double gastosTotalDep(String nome){
        return db.gastosTotalDep(nome);
    }
    
    public String[] funcionarios(){
        return db.funcionarios();
    }
    
    public String[] tecnicos(){
        return db.tecnicos();
    }
    
    public String[] docentes(){
        return db.docentes();
    }
    
    public String[] docentesEfetivos(){
        return db.docentesEfetivos();
    }
    
    public String[] docentesSubstitutos(){
        return db.docentesSubstitutos();
    }
    
    public String[] funcionariosComFaixaDeSal(double minimo, double max){
        return db.funcionariosComFaixaDeSal(minimo, max);
    }
    
    public String[] resumoDepartamentosNaFaixa(double minimo, double max){
        return db.resumoDepartamentosNaFaixa(minimo, max);
    }
    
    public String[] resumoDepartamento(){
        return db.resumoDepartamento();
    }
    
    public String[] geral(){
        return db.geral();
    }
}
