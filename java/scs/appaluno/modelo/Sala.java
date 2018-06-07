package scs.appaluno.modelo;

import java.io.Serializable;

/**
 * Created by joaoc_000 on 19/05/2018.
 */

public class Sala implements Serializable
{
    private String nome;
    private int predio;
    private String bloco;
    private int pavimento;

    public Sala()
    {
    }

    public Sala(String nome, int predio, String bloco, int pavimento) {
        this.nome = nome;
        this.predio = predio;
        this.bloco = bloco;
        this.pavimento = pavimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPredio() {
        return predio;
    }

    public void setPredio(int predio) {
        this.predio = predio;
    }

    public String getBloco() {
        return bloco;
    }

    public void setBloco(String bloco) {
        this.bloco = bloco;
    }

    public int getPavimento() {
        return pavimento;
    }

    public void setPavimento(int pavimento) {
        this.pavimento = pavimento;
    }
}
