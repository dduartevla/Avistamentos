package br.ufjf.dcc196.izabel.avistamentos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerAvistamento;
    List<Avistamento> avistamentos;
    AvistamentoAdapter avistamentoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        avistamentos = new ArrayList<Avistamento>(){{
            add (new Avistamento("Bem-te-vi","Pitangus sulphuratus"));
            add (new Avistamento("Martim-pescador","Megaceryle torquata"));
            add (new Avistamento("João-de-barro", "Furnarius rufus"));
        }};
        recyclerAvistamento = findViewById(R.id.recyclerAvistamento);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerAvistamento.setLayoutManager(layoutManager);
        AvistamentoAdapter.OnAvistamentoClickListener listener = new AvistamentoAdapter.OnAvistamentoClickListener() {
            @Override
            public void onAvistamentoClick(View view, int position) {
                Avistamento avistamento = avistamentos.get(position);
                avistamento.setAvistamento(avistamento.getAvistamento()+1);
                avistamentoAdapter.notifyItemChanged(position);
            }
        };
        avistamentoAdapter = new AvistamentoAdapter(avistamentos,listener);
        recyclerAvistamento.setAdapter(avistamentoAdapter);
    }
}