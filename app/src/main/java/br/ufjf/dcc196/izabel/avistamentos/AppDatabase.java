package br.ufjf.dcc196.izabel.avistamentos;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Avistamento.class}, version =1)
public  abstract class AppDatabase extends RoomDatabase{
    private static AppDatabase INSTANCE;
    public static final String DATABASE_NAME = "avistamento-db";

    public abstract AvistamentoDAO avistamentoDao();

    public static AppDatabase getInstance(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(
                    context.getApplicationContext(),
                    AppDatabase.class,
                    DATABASE_NAME
            ).allowMainThreadQueries().build();
        }
        return INSTANCE;
    }
}
