package br.ufjf.dcc196.izabel.avistamentos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AdicionaEspecie extends AppCompatActivity {

    private Button buttonSalvar;
    private Button buttonCancelar;

    private EditText editTextNome;
    private EditText editTextEspecie;

    private String nome;
    private String especie;

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
        try {
            Intent novaEspecie = new Intent();

            nome = editTextNome.getText().toString();
            especie = editTextEspecie.getText().toString();

            novaEspecie.putExtra("nome", nome);
            novaEspecie.putExtra("especie", especie);

            setResult(1, novaEspecie);
            finish();
        } catch (Exception e){
            editTextNome.selectAll();
            editTextEspecie.requestFocus();

            editTextEspecie.selectAll();
            editTextEspecie.requestFocus();
        }
    }

    public void buttonCancelarClick(View view){
        finish();
    }
}