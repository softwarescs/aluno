package scs.appaluno;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import scs.appaluno.dados.SalaCR;
import scs.appaluno.modelo.Sala;

public class SalaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sala);

        Intent getIntent = getIntent();
        Bundle getBundle = getIntent.getExtras();

        String string = getBundle.getString("bundle");

        SalaCR salaCR = new SalaCR();
        Sala sala = salaCR.ConsultarSala(string);

        TextView txvNome = (TextView) findViewById(R.id.txvNome);
        txvNome.setText(sala.getNome());

        TextView txvPredio = (TextView) findViewById(R.id.txvPredio);
        txvPredio.setText("Prédio: "+sala.getPredio());

        TextView txvBloco = (TextView) findViewById(R.id.txvBloco);
        txvBloco.setText("Bloco: "+sala.getBloco());

        TextView txvPavimento = (TextView) findViewById(R.id.txvPavimento);
        txvPavimento.setText("Pavimento: "+sala.getPavimento());
    }
}
