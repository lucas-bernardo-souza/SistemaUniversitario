/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import gerenciador.principal.Departamento;
import gerenciador.principal.Funcionario;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author Lucas Bernardo
 */
public class DataBase {

    private Departamento departamentos[];
    private int max = 50;
    private int cont;
    private static DataBase instance = null;

    private DataBase() {
        departamentos = new Departamento[max];
        cont = 0;
    }

    public static DataBase getInstance() {
        if (instance == null) {
            instance = new DataBase();
        }
        return instance;
    }

    public void addDepartamento(Departamento d) {
        departamentos[cont] = d;
        cont++;
    }

    public void addTecnico(Funcionario tecnico, int pos) {
        departamentos[pos].addFun(tecnico);
    }

    public void addDocenteEfetivo(Funcionario efetivo, int pos) {
        departamentos[pos].addFun(efetivo);
    }

    public void addDocenteSub(Funcionario substituto, int pos) {
        departamentos[pos].addFun(substituto);
    }

    public boolean depVazio() {
        if (cont == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int buscaPosDep(String nome) {
        if (depVazio()) {
            return -1;
        } else {
            for (int i = 0; i < cont; i++) {
                if (departamentos[i].getNome().equals(nome)) {
                    return i; //Retorna a posição do objeto departamento
                }
            }
        }
        return -1;
    }

    public Departamento buscaDepNome(String nome) {
        if (depVazio()) //Se não tiver nenhum departamento cadastrado retorna nulo
        {
            return null;
        } else {
            for (int i = 0; i < cont; i++) {
                if (departamentos[i].getNome().equals(nome)) {
                    return departamentos[i];
                }
            }
        }
        return null; //Se não achar o departamento retorn nulo
    }

    public Departamento buscaDepCodigo(String codigo) {
        if (depVazio()) {
            return null;
        } else {
            for (int i = 0; i < cont; i++) {
                if (departamentos[i].getCodigo().equals(codigo)) {
                    return departamentos[i];
                }
            }
        }
        return null;
    }

    public Departamento buscaDep(int i) {
        if (depVazio()) {
            return null;
        } else {
            return departamentos[i];
        }
    }

    public int getMax() {
        return max;
    }

    public int getCont() {
        return cont;
    }

    public boolean espacoDispDep(String nome) {
        int i = buscaPosDep(nome);
        return departamentos[i].verificaEspacoLivre(); //False array cheio True espaço disponível
    }

    public Funcionario buscaFuncionarioCod(String codigo, String nomeDep) {
        int pos = buscaPosDep(nomeDep);
        return departamentos[pos].buscaFunCod(codigo);
    }

    public Funcionario buscaFuncionarioNome(String nome, String nomeDep) {
        int pos = buscaPosDep(nomeDep);
        return departamentos[pos].buscaFunNome(nome);
    }

    public String[] nomesFuncionarios(String nomeDep) {
        Departamento d = buscaDepNome(nomeDep);
        return d.nomeFuncionarios();
    }

    public String[] nomesDepartamentos() {
        String nomes[] = new String[cont];
        for (int i = 0; i < cont; i++) {
            nomes[i] = departamentos[i].getNome();
        }
        return nomes;
    }

    public double gastosTotalDep(String nome) {
        Departamento d = buscaDepNome(nome);
        return d.gastosTotal();
    }

    public String[] funcionarios() {
        int quantFun = 0;
        int position = 0;
        String fun[];
        for (int i = 0; i < cont; i++) {
            quantFun += departamentos[i].getCont();
        }
        fun = new String[quantFun];
        for (int i = 0; i < cont; i++) {
            String funcionario[] = departamentos[i].funcionariosDep();
            for (String object : funcionario) {
                fun[position] = object;
                position++;
            }
        }
        return fun;
    }

    public String[] tecnicos() {
        int quantFun = 0;
        int position = 0;
        String fun[];
        for (int i = 0; i < cont; i++) {
            quantFun += departamentos[i].getCont();
        }
        fun = new String[quantFun];
        for (int i = 0; i < cont; i++) {
            String funcionario[] = departamentos[i].tecnicosDep();
            for (String object : funcionario) {
                fun[position] = object;
                position++;
            }
        }
        return fun;
    }

    public String[] docentes() {
        int quantFun = 0;
        int position = 0;
        String fun[];
        for (int i = 0; i < cont; i++) {
            quantFun += departamentos[i].getCont();
        }
        fun = new String[quantFun];
        for (int i = 0; i < cont; i++) {
            String funcionario[] = departamentos[i].docentesDep();
            for (String object : funcionario) {
                fun[position] = object;
                position++;
            }
        }
        return fun;
    }

    public String[] docentesEfetivos() {
        int quantFun = 0;
        int position = 0;
        String fun[];
        for (int i = 0; i < cont; i++) {
            quantFun += departamentos[i].getCont();
        }
        fun = new String[quantFun];
        for (int i = 0; i < cont; i++) {
            String funcionario[] = departamentos[i].docentesEfetivos();
            for (String object : funcionario) {
                fun[position] = object;
                position++;
            }
        }
        return fun;
    }

    public String[] docentesSubstitutos() {
        int quantFun = 0;
        int position = 0;
        String fun[];
        for (int i = 0; i < cont; i++) {
            quantFun += departamentos[i].getCont();
        }
        fun = new String[quantFun];
        for (int i = 0; i < cont; i++) {
            String funcionario[] = departamentos[i].docentesSubstitutos();
            for (String object : funcionario) {
                fun[position] = object;
                position++;
            }
        }
        return fun;
    }

    public String[] funcionariosComFaixaDeSal(double minimo, double max) {
        int dim = 0;
        for (int i = 0; i < cont; i++) {
            dim += departamentos[i].contaFuncionariosComFaixaSal(minimo, max);
        }
        String fun[] = new String[dim];
        dim = 0;
        for (int i = 0; i < cont; i++) {
            String funDoDepartamento[] = departamentos[i].funcionariosComFaixaDeSal(minimo, max);
            for (String object : funDoDepartamento) {
                fun[dim] = object;
                dim++;
            }
        }
        return fun;
    }

    public String[] resumoDepartamentosNaFaixa(double minimo, double max) {
        //Contando os departamentos que estão dentro da faixa de valores
        int dim = 0;
        for (int i = 0; i < cont; i++) {
            if ((minimo < departamentos[i].gastosTotal()) && (departamentos[i].gastosTotal() < max)) {
                dim++;
            }
        }
        String deps[] = new String[dim];
        dim = 0;
        //Criando o array com os dados dos departamentos
        for (int i = 0; i < cont; i++) {
            if ((minimo < departamentos[i].gastosTotal()) && (departamentos[i].gastosTotal() < max)) {
                deps[dim] = departamentos[i].toString();
                dim++;
            }
        }
        return deps;
    }

    public String[] resumoDepartamento() {
        String resumo[] = new String[cont];
        for (int i = 0; i < cont; i++) {
            resumo[i] = departamentos[i].resumo();
        }
        return resumo;
    }

    public String[] geral() {
        int quant = 0;
        for(int i = 0; i<cont; i++){
            quant += departamentos[i].getCont();
        }
        quant += cont;
        String deps[] = new String[quant];
        quant = 0; //reaproveitando a variável
        for (int i = 0; i < cont; i++) {
            String funcionario[] = departamentos[i].geral();
            for (String object : funcionario) {
                deps[quant] = object;
                quant++;
            }
            deps[quant] = "Gasto total do Departamento: " + Double.toString(departamentos[i].gastosTotal()) + "\n";
            quant++;
        }
        return deps;
    }
}
