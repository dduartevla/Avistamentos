package br.ufjf.dcc196.izabel.avistamentos;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityResultLauncher<Intent> launcher;
    RecyclerView recyclerAvistamento;
    List<Avistamento> avistamentos;
    AvistamentoAdapter avistamentoAdapter;

    AvistamentosRepository repo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        repo = new AvistamentosRepository(getApplicationContext());
        recyclerAvistamento = findViewById(R.id.recyclerAvistamento);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerAvistamento.setLayoutManager(layoutManager);

        AvistamentoAdapter.OnAvistamentoClickListener listener = new AvistamentoAdapter.OnAvistamentoClickListener() {
            @Override
            public void onAvistamentoClick(View view, int position) {
                Avistamento avistamento = repo.getAvistamento(position);
                avistamento.setAvistamento(avistamento.getAvistamento()+1);
                avistamentoAdapter.notifyItemChanged(position);
            }
        };
        avistamentoAdapter = new AvistamentoAdapter(repo.getAvistamentos(),listener);
        recyclerAvistamento.setAdapter(avistamentoAdapter);

        launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        Bundle extras;

                        extras = result.getData().getExtras();
                        String nome = extras.getString("nome");
                        String especie = extras.getString("especie");

                        Avistamento novoAvistamento= new Avistamento(nome,especie);
                        repo.addAvistamento(novoAvistamento);

                        avistamentoAdapter = new AvistamentoAdapter(repo.getAvistamentos(),listener);
                        recyclerAvistamento.setAdapter(avistamentoAdapter);

                    }
                }
        );
    }

    public void adicionaEspecie(View view){

        Intent intent = new Intent(MainActivity.this, AdicionaEspecie.class);

        launcher.launch(intent);

    }
}