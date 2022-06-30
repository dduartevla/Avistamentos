package br.ufjf.dcc196.izabel.avistamentos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerAvistamento;
    List<Avistamento> avistamentos;

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
    }
}