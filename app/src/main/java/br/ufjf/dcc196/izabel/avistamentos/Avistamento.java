package br.ufjf.dcc196.izabel.avistamentos;

public class Avistamento {
    private String nome;
    private String especie;
    private int avistamento;

    public Avistamento (String nome, String especie, int avistamento){
        this.nome = nome;
        this.especie = especie;
        this.avistamento = avistamento;
    }

    public Avistamento(String nome, String especie){
        this (nome, especie, null);
    }

    public Avistamento(){
        this(null, null, 0 );
    }

    public int getAvistamento() {
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
}
