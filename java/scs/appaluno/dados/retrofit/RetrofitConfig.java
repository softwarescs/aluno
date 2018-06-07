package scs.appaluno.dados.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import scs.appaluno.dados.retrofit.servicos.CursoDeserialize;
import scs.appaluno.dados.retrofit.servicos.SalaDeserialize;
import scs.appaluno.dados.retrofit.servicos.TurmaDeserialize;
import scs.appaluno.modelo.Curso;
import scs.appaluno.modelo.Sala;
import scs.appaluno.modelo.Turma;

/**
 * Created by joaoc_000 on 20/05/2018.
 */

public class RetrofitConfig
{
    private Retrofit retrofit;

    public RetrofitConfig(String objeto)
    {
        if(objeto.equals("turma"))
        {
            Gson gsonConverterTurma = new GsonBuilder().registerTypeAdapter(Turma.class, new TurmaDeserialize()).create();
            this.retrofit = new Retrofit.Builder()
                    .baseUrl("http://sistemaconsultadesala.000webhostapp.com/scs/appfuncionario/apresentacao/")
                    .addConverterFactory(GsonConverterFactory.create(gsonConverterTurma))
                    .build();
        }
        else if(objeto.equals("curso"))
        {
            Gson gsonConverterCurso = new GsonBuilder().registerTypeAdapter(Curso.class, new CursoDeserialize()).create();
            this.retrofit = new Retrofit.Builder()
                    .baseUrl("http://sistemaconsultadesala.000webhostapp.com/scs/appfuncionario/apresentacao/")
                    .addConverterFactory(GsonConverterFactory.create(gsonConverterCurso))
                    .build();
        }
        else if(objeto.equals("sala"))
        {
            Gson gsonConverterSala = new GsonBuilder().registerTypeAdapter(Sala.class, new SalaDeserialize()).create();
            this.retrofit = new Retrofit.Builder()
                    .baseUrl("http://sistemaconsultadesala.000webhostapp.com/scs/appfuncionario/apresentacao/")
                    .addConverterFactory(GsonConverterFactory.create(gsonConverterSala))
                    .build();
        }
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }
}
