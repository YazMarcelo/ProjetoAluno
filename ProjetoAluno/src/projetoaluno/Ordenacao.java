/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoaluno;

import classededados.Aluno;
import java.util.ArrayList;

/**
 *
 * @author aluno
 */
public class Ordenacao {

    public Aluno[] ordenacaoMatricula(Aluno[] listaDeAlunos) {
        int i, j;
        Aluno aux = new Aluno();
        Aluno aux2 = new Aluno();
        for (i = listaDeAlunos.length - 1; i > 0; i--) {
            // o maior valor entre vet[0] e vet[i] vai para a posição vet[i]
            for (j = 0; j < i; j++) {
                if (Long.parseLong(listaDeAlunos[j].getMatricula().replace(".", "")) < Long.parseLong(listaDeAlunos[j + 1].getMatricula().replace(".", ""))) {
                    aux = listaDeAlunos[j];
                    listaDeAlunos[j] = listaDeAlunos[j + 1];
                    listaDeAlunos[j + 1] = aux;
                }
            }
        }
        return listaDeAlunos;
    }
    
        public Aluno[] ordenacaoNome(Aluno[] listaDeAlunos) {
        int i, j;
        Aluno aux = new Aluno();
        for (i = listaDeAlunos.length - 1; i > 0; i--) {
            // o maior valor entre vet[0] e vet[i] vai para a posição vet[i]
            for (j = 0; j < i; j++) {
                char letra = 'a';
                char letra2 = 'a';
                int c = 0;
                int tamanho = (listaDeAlunos[j + 1].getNome().toLowerCase()).length();
                if(tamanho > (listaDeAlunos[j].getNome().toLowerCase()).length())
                    tamanho = (listaDeAlunos[j].getNome().toLowerCase()).length();
                
                while(c < tamanho){
                    if(letra == letra2){
                    letra = listaDeAlunos[j].getNome().toLowerCase().charAt(c);
                    letra2 = (listaDeAlunos[j + 1].getNome().toLowerCase()).charAt(c);
                    }else{
                        break;
                    }
                    c++;
                }
                
                if (letra < letra2) {
                    aux = listaDeAlunos[j];
                    listaDeAlunos[j] = listaDeAlunos[j + 1];
                    listaDeAlunos[j + 1] = aux;
                }
            }
        }
        return listaDeAlunos;
    }
}
