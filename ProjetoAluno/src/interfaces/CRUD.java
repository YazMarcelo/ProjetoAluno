/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import classededados.Aluno;
import java.util.ArrayList;

/**
 *
 * @author aluno
 */
public interface CRUD {
    public Aluno[] recuperarAluno()throws Exception;
    public ArrayList<Aluno> ordenarAluno()throws Exception;
}
