package scs.appaluno.dados.retrofit.servicos;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import scs.appaluno.modelo.Turma;

/**
 * Created by joaoc_000 on 20/05/2018.
 */

public interface ITurmasServico
{
    @GET("ws.php?turmas")
    Call<List<Turma>> buscarTurmas();
}
