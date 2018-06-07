package scs.appaluno.dados.retrofit.servicos;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import scs.appaluno.modelo.Curso;

/**
 * Created by joaoc_000 on 21/05/2018.
 */

public interface ICursosServico
{
    @GET("ws.php?cursos")
    Call<List<Curso>> buscarCursos();
}
