package scs.appaluno.dados;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.List;

import scs.appaluno.modelo.Curso;

/**
 * Created by joaoc_000 on 21/05/2018.
 */

public class CursoCR extends BancoDados
{
    public CursoCR()
    {
    }

    public String[] ConsultarNomesCursos()
    {
        this.conexao = this.getReadableDatabase();
        this.sql = "SELECT * FROM cursos";
        Cursor cursor = this.conexao.rawQuery(this.sql, null);
        String[] cursosNomes = new String[cursor.getCount()];

        if(cursor.moveToFirst())
        {
            do
            {
                cursosNomes[cursor.getPosition()] = cursor.getString(cursor.getColumnIndex("nome"));
            }
            while(cursor.moveToNext());
            cursor.close();
        }

        this.conexao.close();
        return cursosNomes;
    }

    public boolean AdicionarCursos(List<Curso> cursos)
    {
        this.conexao = this.getWritableDatabase();

        try
        {
            for (Curso curso: cursos)
            {
                ContentValues contentValues = new ContentValues();
                contentValues.put("nome", curso.getNome());
                contentValues.put("areaAtuacao", curso.getAreaAtuacao());

                this.conexao.insert("cursos", null, contentValues);
            }

            this.conexao.close();
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }
}
