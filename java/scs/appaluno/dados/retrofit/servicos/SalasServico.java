package scs.appaluno.dados.retrofit.servicos;

import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import scs.appaluno.dados.SalaCR;
import scs.appaluno.dados.retrofit.RetrofitConfig;
import scs.appaluno.modelo.Sala;

/**
 * Created by joaoc_000 on 21/05/2018.
 */

public class SalasServico
{
    private final RetrofitConfig retrofit;

    public SalasServico()
    {
        this.retrofit = new RetrofitConfig("sala");
    }

    public ISalasServico getSalasServico()
    {
        Retrofit retrofit = this.retrofit.getRetrofit();
        return retrofit.create(ISalasServico.class);
    }

    public void getSalas()
    {
        ISalasServico salasServico = this.getSalasServico();
        Call<List<Sala>> call = salasServico.buscarSalas();

        call.enqueue(new Callback<List<Sala>>() {
            @Override
            public void onResponse(Call<List<Sala>> call, Response<List<Sala>> response) {
                List<Sala> salas = response.body();

                SalaCR salaCR = new SalaCR();
                salaCR.AdicionarSalas(salas);

                for (Sala sala : salas) {
                    Log.e("Salas", sala.getNome());
                }
            }

            @Override
            public void onFailure(Call<List<Sala>> call, Throwable t) {
                Log.e("SalasServico", "onFailure: "+t.getMessage());
            }
        });
    }
}