package scs.appaluno.dados;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import scs.appaluno.MyApp;

/**
 * Created by joaoc_000 on 19/05/2018.
 */

public class BancoDados extends SQLiteOpenHelper
{
    private static int versao = 1;
    private static String nome = "scs.db";
    protected SQLiteDatabase conexao;
    protected String sql;

    public BancoDados()
    {
        super(MyApp.getContexto(), nome, null, versao);
    }

    @Override
    public void onCreate(SQLiteDatabase bancoDados)
    {
//        Adicionar tabelas no banco de dados
        this.AdicionarTabelas();
    }

    @Override
    public void onUpgrade(SQLiteDatabase bancoDados, int versaoAnterior, int versaoAtual)
    {
//        Remover tabelas do banco de dados
        this.RemoverTabelas();

//        Adicionar tabelas no banco de dados novamente
        this.onCreate(bancoDados);
    }

    public boolean AdicionarTabelas()
    {
        this.conexao = this.getWritableDatabase();

        try
        {
//            Adicionar tabela Turmas
            this.sql = "CREATE TABLE IF NOT EXISTS turmas(" +
                    "cursos_nome VARCHAR(45) NOT NULL, " +
                    "periodo VARCHAR(10) NOT NULL," +
                    "semestre INTEGER NOT NULL," +
                    "salas_nome VARCHAR(10) NOT NULL," +
                    "PRIMARY KEY (cursos_nome, periodo, semestre));";
            this.conexao.execSQL(this.sql);

//            Adicionar tabela Cursos
            this.sql = "CREATE TABLE IF NOT EXISTS cursos(" +
                    "nome VARCHAR(45) PRIMARY KEY NOT NULL, " +
                    "areaAtuacao VARCHAR(10) NOT NULL);";
            this.conexao.execSQL(this.sql);

//            Adicionar tabela Salas
            this.sql = "CREATE TABLE IF NOT EXISTS salas(" +
                    "nome VARCHAR(10) PRIMARY KEY NOT NULL, " +
                    "predio INTEGER NOT NULL," +
                    "bloco VARCHAR(1) NOT NULL," +
                    "pavimento INTEGER NOT NULL);";
            this.conexao.execSQL(this.sql);

            this.conexao.close();
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public boolean RemoverTabelas()
    {
        this.conexao = this.getWritableDatabase();

        try
        {
//            Remover tabela Turmas
            this.sql = "DROP TABLE IF EXISTS turmas";
            this.conexao.execSQL(this.sql);

//            Remover tabela Cursos
            this.sql = "DROP TABLE IF EXISTS cursos";
            this.conexao.execSQL(this.sql);

//            Remover tabela Salas
            this.sql = "DROP TABLE IF EXISTS salas";
            this.conexao.execSQL(this.sql);

            this.conexao.close();
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
}
