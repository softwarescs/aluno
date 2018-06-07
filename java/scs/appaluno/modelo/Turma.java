package scs.appaluno.modelo;

import java.io.Serializable;

/**
 * Created by joaoc_000 on 19/05/2018.
 */

public class Turma implements Serializable
{
    private String cursos_nome;
    private String periodo;
    private int semestre;
    private String salas_nome;

    public Turma()
    {
    }

    public Turma(String cursos_nome, String periodo, int semestre, String salas_nome) {
        this.cursos_nome = cursos_nome;
        this.periodo = periodo;
        this.semestre = semestre;
        this.salas_nome = salas_nome;
    }

    public String getCursos_nome() {
        return cursos_nome;
    }

    public void setCursos_nome(String cursos_nome) {
        this.cursos_nome = cursos_nome;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public String getSalas_nome() {
        return salas_nome;
    }

    public void setSalas_nome(String salas_nome) {
        this.salas_nome = salas_nome;
    }

    @Override
    public String toString() {
        return semestre+" semestre "+periodo;
    }
}
