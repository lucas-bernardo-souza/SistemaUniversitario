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
public class Departamento {

    private String codigo;
    private String nome;
    private Funcionario funcionarios[];
    private int cont;
    private int max;

    private void inicializar(int dim) {
        cont = 0;
        max = dim;
        funcionarios = new Funcionario[max];
    }

    public Departamento(String codigo, String nome, int dim) {
        this.codigo = codigo;
        this.nome = nome;
        inicializar(dim);
    }

    public boolean verificaEspacoLivre() {
        if (cont == max) {
            return false; //Array cheio
        } else {
            return true; //Espaço disponível
        }
    }

    public void addFun(Funcionario funcionario) {
        if (cont < max) {
            this.funcionarios[cont] = funcionario;
            cont++;
        }
    }

    public Funcionario buscaFunCod(String codigo) {
        for (int i = 0; i < cont; i++) {
            if (funcionarios[i].codigo.equals(codigo)) {
                return funcionarios[i];
            }
        }
        return null;
    }

    public Funcionario buscaFunNome(String nome) {
        for (int i = 0; i < cont; i++) {
            if (funcionarios[i].nome.equals(nome)) {
                return funcionarios[i];
            }
        }
        return null;
    }

    public String[] nomeFuncionarios() {
        String nomes[] = new String[cont];
        for (int i = 0; i < cont; i++) {
            nomes[i] = funcionarios[i].getNome();
        }
        return nomes;
    }

    public double gastosTotal() {
        double gastos = 0;
        for (int i = 0; i < cont; i++) {
            gastos += funcionarios[i].salario;
        }
        return gastos;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public int getCont() {
        return cont;
    }

    public Funcionario[] getFuncionario() {
        return funcionarios;
    }

    public String[] funcionariosDep() {
        String fun[] = new String[cont];
        for (int i = 0; i < cont; i++) {
            fun[i] = funcionarios[i].toString();
        }
        return fun;
    }

    public String[] tecnicosDep() {
/*        int dim = 0;
        for(int i = 0; i < cont; i++){
            if(funcionarios[i].getTipo().equals("T")){
                dim++;
            }
       }*/ 
        String fun[] = new String[cont];
        for (int i = 0; i < cont; i++) {
            if(funcionarios[i].getTipo().equals("T")){
                fun[i] = funcionarios[i].toString();
            }
        }
        return fun;
    }
    
    public String[] docentesDep(){
/*        int dim = 0;
        for(int i = 0; i < cont; i++){
            if((funcionarios[i].getTipo().equals("E")) || (funcionarios[i].getTipo().equals("S"))){
                dim++;
            }
        }*/
        String fun[] = new String[cont];
        for (int i = 0; i < cont; i++) {
            if((funcionarios[i].getTipo().equals("E")) || (funcionarios[i].getTipo().equals("S"))){
                fun[i] = funcionarios[i].toString();
            }
        }
        return fun;
    }
    
    public String[] docentesEfetivos(){
        String fun[] = new String[cont];
        for (int i = 0; i < cont; i++) {
            if(funcionarios[i].getTipo().equals("E")){
                fun[i] = funcionarios[i].toString();
            }
        }
        return fun;
    }
    
    public String[] docentesSubstitutos(){
        String fun[] = new String[cont];
        for (int i = 0; i < cont; i++) {
            if(funcionarios[i].getTipo().equals("S")){
                fun[i] = funcionarios[i].toString();
            }
        }
        return fun;
    }
    
    public int contaFuncionariosComFaixaSal(double minimo, double max){
        int dim = 0;
        for(int i = 0; i < cont; i++){
            if((minimo < funcionarios[i].salario) && (funcionarios[i].salario < max)){
                dim++;
            }
        }
        return dim;
    }
    
    public String[] funcionariosComFaixaDeSal(double minimo, double max){
        String fun[];
        int dim = contaFuncionariosComFaixaSal(minimo, max);
        fun = new String[dim];
        dim = 0;
        for(int i = 0; i < cont; i++){
            if((minimo < funcionarios[i].salario) && (funcionarios[i].salario < max)){
                fun[dim] = funcionarios[i].toString();
                dim++;
            }
        }
        return fun;
    }
    
    public String toString(){
        String q = Integer.toString(cont);
        String dep = codigo + " - " + nome + " - " + q + "\n";
        return dep;
    }
    
    public String resumo(){
        String q = Integer.toString(cont);
        String gastos = Double.toString(gastosTotal());
        String resumo = "Código: " + codigo + " - " + "Nome: " + nome + " - " + "Func.:" + q + " - " + "Gastos: " + gastos + "\n";
        return resumo;
    }
    
    public String[] geral(){
        String fun[] = new String[cont];
        for(int i = 0; i < cont; i++){
            fun[i] = "Departamento: "+ nome + " - " + "Funcionário: " + funcionarios[i].toString();
        }
        return fun;
    }
}
