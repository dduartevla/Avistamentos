package br.ufjf.dcc196.izabel.avistamentos;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.List;

public class AvistamentosRepository {
    private Context context;
    private SharedPreferences preferences;
    private final String PREFERENCES_NAME = "br.ufjf.dcc196.izabel.avistamentos";

    private List<Avistamento> avistamentos;

    public AvistamentosRepository(Context context){
        this.context = context;
        preferences = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        avistamentos = new ArrayList<Avistamento>();
    }

    private void auxBotaAvistamentos(){
        new Avistamento("Bem-te-vi","Pitangus sulphuratus");
        new Avistamento("Martim-pescador","Megaceryle torquata");
        new Avistamento("João-de-barro", "Furnarius rufus");
    }

    public void addAvistamento(Avistamento novoAvistamento){
        avistamentos.add(novoAvistamento);
    }

    public Avistamento getAvistamento(int position){
        return avistamentos.get(position);
    }

}
