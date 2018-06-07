package scs.appaluno.dados;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import scs.appaluno.modelo.Turma;

/**
 * Created by joaoc_000 on 20/05/2018.
 */

public class TurmaCR extends BancoDados
{
    public TurmaCR()
    {
    }

    public List<Turma> ConsultarTurmas(String cursos_nome, String periodo)
    {
        this.conexao = this.getReadableDatabase();
        this.sql = "SELECT * FROM turmas WHERE cursos_nome=? AND periodo=?";
        String[] filtros = new String[] {cursos_nome, periodo};
        Cursor cursor = this.conexao.rawQuery(this.sql, filtros);

        List<Turma> turmas = this.DeCursorParaListaObjeto(cursor);

        this.conexao.close();
        return turmas;
    }

    public boolean AdicionarTurmas(List<Turma> turmas)
    {
        this.conexao = this.getWritableDatabase();

        try
        {
            for (Turma turma: turmas)
            {
                ContentValues contentValues = new ContentValues();
                contentValues.put("cursos_nome", turma.getCursos_nome());
                contentValues.put("periodo", turma.getPeriodo());
                contentValues.put("semestre", turma.getSemestre());
                contentValues.put("salas_nome", turma.getSalas_nome());

                this.conexao.insert("turmas", null, contentValues);
            }

            this.conexao.close();
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }

    private List<Turma> DeCursorParaListaObjeto(Cursor cursor)
    {
        List<Turma> turmas = new ArrayList<>();

        if(cursor.moveToFirst())
        {
            do
            {
                Turma turma = new Turma();
                turma.setCursos_nome(cursor.getString(cursor.getColumnIndex("cursos_nome")));
                turma.setPeriodo(cursor.getString(cursor.getColumnIndex("periodo")));
                turma.setSemestre(cursor.getInt(cursor.getColumnIndex("semestre")));
                turma.setSalas_nome(cursor.getString(cursor.getColumnIndex("salas_nome")));
                turmas.add(turma);
            }
            while(cursor.moveToNext());

            cursor.close();
        }

        return turmas;
    }
}
