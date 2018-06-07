package scs.appaluno;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import scs.appaluno.dados.BancoDados;
import scs.appaluno.dados.retrofit.servicos.CursosServico;
import scs.appaluno.dados.retrofit.servicos.SalasServico;
import scs.appaluno.dados.retrofit.servicos.TurmasServico;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(getInternetStatus())
        {
            Log.e("Conexao", "ONLINE");

            BancoDados bancoDados = new BancoDados();
            bancoDados.RemoverTabelas();
            bancoDados.AdicionarTabelas();

//            TURMAS
            TurmasServico turmasServico = new TurmasServico();
            turmasServico.getTurmas();

//            CURSOS
            CursosServico cursosServico = new CursosServico();
            cursosServico.getCursos();

//            SALAS
            SalasServico salasServico = new SalasServico();
            salasServico.getSalas();
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, ConsultarActivity.class);
                startActivity(intent);

                finish();
            }
        }, 3000);
    }

    private boolean getInternetStatus()
    {
        ConnectivityManager cm = (ConnectivityManager)this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();

        boolean status = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();

        return status;
    }
}
