/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import classededados.Aluno;
import interfaces.CRUD;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author aluno
 */
public class ClasseDAO implements CRUD {

    private String arquivoAluno = "C:\\Users\\selecta\\Documents\\NetBeansProjects\\ProjetoAluno\\ProjetoAluno\\src\\arquivo\\ListaGeralDeDados.csv";

    @Override
    public Aluno[] recuperarAluno() throws Exception {
        Aluno listaDeAluno[] = new Aluno[901];
        Aluno objAluno = null;

        FileReader frAluno = new FileReader(arquivoAluno);
        BufferedReader br = new BufferedReader(frAluno);
        String linha = "";
        int i = 0;
        while ((linha = br.readLine()) != null) {
            String vector[] = linha.split(";");

            objAluno = new Aluno();
            objAluno.setMatricula(vector[0]);
            objAluno.setNome(vector[1]);
            objAluno.setTipoDeIngresso(vector[2]);
            objAluno.setTurno(vector[3]);
            objAluno.setMatriz(vector[4]);

            listaDeAluno[i] = objAluno;
            i++;
        }
        br.close();
        return listaDeAluno;
    }

    @Override
    public ArrayList<Aluno> ordenarAluno() throws Exception {
        return null;
    }

}
