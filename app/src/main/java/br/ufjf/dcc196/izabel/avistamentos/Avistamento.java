package br.ufjf.dcc196.izabel.avistamentos;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Avistamento {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private String nome;
    private String especie;
    private Integer avistamento;

    public Avistamento (String nome, String especie, int avistamento){
        this.nome = nome;
        this.especie = especie;
        this.avistamento = avistamento;
    }

    public Avistamento (Long id,String nome, String especie, int avistamento){
        this.nome = nome;
        this.id = id;
        this.especie = especie;
        this.avistamento = avistamento;
    }

    public Avistamento(String nome, String especie){
        this (nome, especie,0);
    }

    public Avistamento(){
        this(null, null, 0 );
    }

    public Integer getAvistamento() {
        return avistamento;
    }

    public void setAvistamento(int avistamento) {
        this.avistamento = avistamento;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getId() { return id; }

    public void setId(long id) {this.id = id; }
}
