package scs.appaluno.modelo;

import java.io.Serializable;

/**
 * Created by joaoc_000 on 20/05/2018.
 */

public class Curso implements Serializable
{
    private String nome;
    private String areaAtuacao;

    public Curso()
    {
    }

    public Curso(String nome, String areaAtuacao) {
        this.nome = nome;
        this.areaAtuacao = areaAtuacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAreaAtuacao() {
        return areaAtuacao;
    }

    public void setAreaAtuacao(String areaAtuacao) {
        this.areaAtuacao = areaAtuacao;
    }
}
