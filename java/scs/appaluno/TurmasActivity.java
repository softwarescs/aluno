package scs.appaluno;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import scs.appaluno.dados.TurmaCR;
import scs.appaluno.modelo.Turma;

public class TurmasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turmas);

        Intent getIntent = getIntent();
        Bundle getBundle = getIntent.getExtras();

        String[] strings = getBundle.getStringArray("bundle");

        TurmaCR turmaCR = new TurmaCR();
        List<Turma> turmas = turmaCR.ConsultarTurmas(strings[0], strings[1]);

        TextView txvTurmas = (TextView) findViewById(R.id.txvTurmas);
        txvTurmas.setText(strings[0]);

        final ListView ltvTurmas = (ListView) findViewById(R.id.ltvTurmas);
        final ArrayAdapter<Turma> adapterTurmas = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, turmas);
        ltvTurmas.setAdapter(adapterTurmas);

        ltvTurmas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Turma turma = adapterTurmas.getItem(position);
                String string = turma.getSalas_nome();

                Bundle bundle = new Bundle();
                bundle.putString("bundle", string);

                Intent intent = new Intent(TurmasActivity.this, SalaActivity.class);
                intent.putExtras(bundle);

                startActivity(intent);
            }
        });
    }
}
