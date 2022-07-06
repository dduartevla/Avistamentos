package br.ufjf.dcc196.izabel.avistamentos;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AdicionaEspecie extends AppCompatActivity {

    Button buttonSalvar;
    Button buttonCancelar;

    EditText editTextNome;
    EditText editTextEspecie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adiciona_especie);

        buttonSalvar = findViewById(R.id.buttonSalvar);
        buttonCancelar = findViewById(R.id.buttonCancelar);

        editTextNome = findViewById(R.id.editTextNome);
        editTextEspecie = findViewById(R.id.editTextEspecie);
    }

    public void buttonSalvarClick(View view){

    }

    public void buttonCancelarClick(View view){
        finish();
    }
}