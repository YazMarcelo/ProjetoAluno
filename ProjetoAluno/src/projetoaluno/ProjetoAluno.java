/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoaluno;

import classededados.Aluno;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import persistencia.ClasseDAO;
import projetoaluno.Ordenacao;

/**
 *
 * @author aluno
 */
public class ProjetoAluno {

    /**
     * @param args the command line arguments
     */
    public static void listar(Aluno[] listaDeAlunos){
                for (int pos = 1; pos < listaDeAlunos.length; pos++) {
                    String[] saida = new String[4];
                    Aluno aux = listaDeAlunos[pos];

                    String nome = aux.getNome();
                    String tipoIngresso = aux.getTipoDeIngresso();
                    String turno = aux.getTurno();

                    while (nome.length() < 50) {
                        nome = nome + " ";
                    }
                    while (tipoIngresso.length() < 12) {
                        tipoIngresso = tipoIngresso + " ";
                    }
                    while (turno.length() < 10) {
                        turno = turno + " ";
                    }

                    System.out.print(aux.getMatricula() + " - " + nome + " - " + tipoIngresso + " - " + turno + " - " + aux.getMatriz() + "\n");
                }
    }
            
    public static void main(String[] args) {
        Ordenacao order = new Ordenacao();
        Scanner leia = new Scanner(System.in);
        System.out.println("Bem vindo!");
        System.out.println("Alunos:");
        try {

            Aluno listaDeAlunos[];
            ClasseDAO daoAluno = new ClasseDAO();
            listaDeAlunos = daoAluno.recuperarAluno();

            System.out.print("MATRICULA      " + " - " + "NOME                                              " + " - " + "INGRESSO    " + " - " + "TURNO     " + " - " + "MATRIZ" + "\n");
            listar(listaDeAlunos);

            System.out.println("O que deseja fazer?");
            System.out.println("1 - Ordenar por matricula");
            System.out.println("2 - Ordenar por nome");
            String res = leia.next();
            while((res.equals("1")) || (res.equals("2")) ){
            
            if (res.equals("1")) {

                System.out.println("A lista será ordenada por método bolha");
                listaDeAlunos = order.ordenacaoMatricula(listaDeAlunos);
                listar(listaDeAlunos);


            } else if(res.equals("2")){
                System.out.println("A lista será ordenada por método bolha");
                listaDeAlunos = order.ordenacaoNome(listaDeAlunos);
                listar(listaDeAlunos);
            }
            System.out.println("O que deseja fazer?");
            System.out.println("1 - Ordenar por matricula");
            System.out.println("2 - Ordenar por nome");
            res = leia.next();
        }
        } catch (Exception erro) {
            Logger.getLogger(ProjetoAluno.class.getName()).log(Level.SEVERE, null, erro);
            JOptionPane.showMessageDialog(null, erro);
        }
    }

}
