package scs.appaluno.dados.retrofit.servicos;

import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import scs.appaluno.dados.CursoCR;
import scs.appaluno.dados.retrofit.RetrofitConfig;
import scs.appaluno.modelo.Curso;

/**
 * Created by joaoc_000 on 21/05/2018.
 */

public class CursosServico
{
    private final RetrofitConfig retrofit;

    public CursosServico()
    {
        this.retrofit = new RetrofitConfig("curso");
    }

    public ICursosServico getCursosServico()
    {
        Retrofit retrofit = this.retrofit.getRetrofit();
        return retrofit.create(ICursosServico.class);
    }

    public void getCursos()
    {
        ICursosServico cursosServico = this.getCursosServico();
        Call<List<Curso>> call = cursosServico.buscarCursos();

        call.enqueue(new Callback<List<Curso>>() {
            @Override
            public void onResponse(Call<List<Curso>> call, Response<List<Curso>> response) {
                List<Curso> cursos = response.body();

                CursoCR cursoCR = new CursoCR();
                cursoCR.AdicionarCursos(cursos);

                for (Curso curso : cursos) {
                    Log.e("Cursos", curso.getNome());
                }
            }

            @Override
            public void onFailure(Call<List<Curso>> call, Throwable t) {
                Log.e("CursosServico", "onFailure: "+t.getMessage());
            }
        });
    }
}