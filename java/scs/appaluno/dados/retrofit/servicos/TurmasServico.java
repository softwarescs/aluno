package scs.appaluno.dados.retrofit.servicos;

import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import scs.appaluno.dados.TurmaCR;
import scs.appaluno.dados.retrofit.RetrofitConfig;
import scs.appaluno.modelo.Turma;

/**
 * Created by joaoc_000 on 20/05/2018.
 */

public class TurmasServico
{
    private final RetrofitConfig retrofit;

    public TurmasServico()
    {
        this.retrofit = new RetrofitConfig("turma");
    }

    public ITurmasServico getTurmasServico()
    {
        Retrofit retrofit = this.retrofit.getRetrofit();
        return retrofit.create(ITurmasServico.class);
    }

    public void getTurmas()
    {
        ITurmasServico turmasServico = this.getTurmasServico();
        Call<List<Turma>> call = turmasServico.buscarTurmas();

        call.enqueue(new Callback<List<Turma>>() {
            @Override
            public void onResponse(Call<List<Turma>> call, Response<List<Turma>> response) {
                List<Turma> turmas = response.body();

                TurmaCR turmaCR = new TurmaCR();
                turmaCR.AdicionarTurmas(turmas);

                for (Turma turma : turmas) {
                    Log.e("Turmas", turma.getPeriodo().toString());
                }
            }

            @Override
            public void onFailure(Call<List<Turma>> call, Throwable t) {
                Log.e("TurmasServico", "onFailure: "+t.getMessage());
            }
        });
    }
}