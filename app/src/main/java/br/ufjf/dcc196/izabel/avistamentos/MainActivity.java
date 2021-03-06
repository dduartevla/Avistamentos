package br.ufjf.dcc196.izabel.avistamentos;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityResultLauncher<Intent> launcher;
    RecyclerView recyclerAvistamento;
    List<Avistamento> avistamentos;
    AvistamentoAdapter avistamentoAdapter;

    AvistamentosRepository repo;

    AvistamentoAdapter.OnAvistamentoClickListener listener;

    private AppDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        repo = new AvistamentosRepository(getApplicationContext());

        db = AppDatabase.getInstance(getApplicationContext());
//        Avistamento a1 = new Avistamento("Bem-te-vu","Pitangus sulphuratus");
//        db.avistamentoDao().criar(a1);

        avistamentos = db.avistamentoDao().listarTodos();
        Avistamento a1 = db.avistamentoDao().buscaPorId(1L);
        repo.addAvistamento(a1);
        a1.setNome("Bem-te-vei");
        db.avistamentoDao().salvar(a1);
        System.out.println(a1.getNome());



        recyclerAvistamento = findViewById(R.id.recyclerAvistamento);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerAvistamento.setLayoutManager(layoutManager);

        listener = new AvistamentoAdapter.OnAvistamentoClickListener() {
            @Override
            public void onAvistamentoClick(View view, int position) {
                Avistamento avistamento = repo.getAvistamento(position);
                avistamento.setAvistamento(avistamento.getAvistamento()+1);
                avistamentoAdapter.notifyItemChanged(position);
            }

            @Override
            public void onSubClik(View view, int position) {
                Avistamento avistamento = repo.getAvistamento(position);
                if (avistamento.getAvistamento()>0)
                avistamento.setAvistamento(avistamento.getAvistamento()-1);
                avistamentoAdapter.notifyItemChanged(position);
            }

            @Override
            public void onAddClick(View view, int position) {
                Avistamento avistamento = repo.getAvistamento(position);
                avistamento.setAvistamento(avistamento.getAvistamento()+1);
                avistamentoAdapter.notifyItemChanged(position);
            }

            @Override
            public void onDeleteClick(View view, int position) {
                repo.removeAvistamento(position);
                avistamentoAdapter = new AvistamentoAdapter(repo.getAvistamentos(),listener);
                recyclerAvistamento.setAdapter(avistamentoAdapter);
                Toast.makeText(MainActivity.this,"Deletado",Toast.LENGTH_SHORT).show();

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

        ItemTouchHelper helper = new ItemTouchHelper(callback);
        helper.attachToRecyclerView(recyclerAvistamento);
    }

    ItemTouchHelper.SimpleCallback callback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

            repo.getAvistamentos().remove(viewHolder.getAdapterPosition());
            avistamentoAdapter = new AvistamentoAdapter(repo.getAvistamentos(),listener);
            recyclerAvistamento.setAdapter(avistamentoAdapter);
            Toast.makeText(MainActivity.this,"Deletado",Toast.LENGTH_SHORT).show();

        }
    };

    public void adicionaEspecie(View view){

        Intent intent = new Intent(MainActivity.this, AdicionaEspecie.class);

        launcher.launch(intent);

    }

}