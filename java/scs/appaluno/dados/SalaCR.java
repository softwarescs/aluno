package scs.appaluno.dados;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.List;

import scs.appaluno.modelo.Sala;

/**
 * Created by joaoc_000 on 21/05/2018.
 */

public class SalaCR extends BancoDados
{
    public SalaCR()
    {
    }

    public Sala ConsultarSala(String nome)
    {
        this.conexao = this.getReadableDatabase();
        this.sql = "SELECT * FROM salas WHERE nome=?";
        String[] filtros = new String[] {nome};
        Cursor cursor = this.conexao.rawQuery(this.sql, filtros);

        Sala sala = this.DeCursorParaObjeto(cursor);

        this.conexao.close();
        return sala;
    }

    public boolean AdicionarSalas(List<Sala> salas)
    {
        this.conexao = this.getWritableDatabase();

        try
        {
            for (Sala sala: salas)
            {
                ContentValues contentValues = new ContentValues();
                contentValues.put("nome", sala.getNome());
                contentValues.put("predio", sala.getPredio());
                contentValues.put("bloco", sala.getBloco());
                contentValues.put("pavimento", sala.getPavimento());

                this.conexao.insert("salas", null, contentValues);
            }

            this.conexao.close();
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }

    private Sala DeCursorParaObjeto(Cursor cursor)
    {
        cursor.moveToFirst();

        Sala sala = new Sala();
        sala.setNome(cursor.getString(cursor.getColumnIndex("nome")));
        sala.setPredio(cursor.getInt(cursor.getColumnIndex("predio")));
        sala.setBloco(cursor.getString(cursor.getColumnIndex("bloco")));
        sala.setPavimento(cursor.getInt(cursor.getColumnIndex("pavimento")));

        cursor.close();
        return sala;
    }
}
