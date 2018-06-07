package scs.appaluno;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import scs.appaluno.dados.CursoCR;

public class ConsultarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar);

        CursoCR cursoCR = new CursoCR();
        String[] cursos = cursoCR.ConsultarNomesCursos();

        final Spinner sprCurso = (Spinner) findViewById(R.id.sprCurso);
        ArrayAdapter<String> adapterCurso = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, cursos);
        adapterCurso.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sprCurso.setAdapter(adapterCurso);

        final Spinner sprPeriodo = (Spinner) findViewById(R.id.sprPeriodo);
        ArrayAdapter<CharSequence> adapterPeriodo = ArrayAdapter.createFromResource(this, R.array.sprPeriodo, android.R.layout.simple_spinner_item);
        adapterPeriodo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sprPeriodo.setAdapter(adapterPeriodo);

        Button btnConsultar = (Button) findViewById(R.id.btnConsultar);
        btnConsultar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int sprCursoPosicao = sprCurso.getSelectedItemPosition();
                String sprCursoString = sprCurso.getItemAtPosition(sprCursoPosicao).toString();

                int sprPeriodoPosicao = sprPeriodo.getSelectedItemPosition();
                String sprPeriodoString = sprPeriodo.getItemAtPosition(sprPeriodoPosicao).toString();

                String[] strings = new String[] {sprCursoString, sprPeriodoString};

                Intent intent = new Intent(ConsultarActivity.this, TurmasActivity.class);
                Bundle bundle = new Bundle();

                bundle.putStringArray("bundle", strings);
                intent.putExtras(bundle);

                startActivity(intent);
            }
        });
    }
}
