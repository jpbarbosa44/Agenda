package com.example.agenda.model;

public class Compromisso {
    private String Nome;
    private String Descricao;
    private String Data;
    private String Hora;


    public Compromisso(String nome, String descricao, String data, String hora){
        this.Nome = nome;
        this.Descricao = descricao;
        this.Data = data;
        this.Hora = hora;
    }

    public String getNome(){
        return Nome;
    }

    public String getDescricao(){
        return Descricao;
    }

    public String getData(){
        return Data;
    }

    public String getHora(){
        return Hora;
    }

    public void setNome(String nome){
        this.Nome = nome;
    }

    public void setDescricao(String descricao){
        this.Descricao = descricao;
    }

    public void setData(String data){
        this.Data = data;
    }

    public void setHora(String hora){
        this.Hora = hora;
    }

    public String ImprimeCompromisso() {
        return "Compromisso{" +
                "nome='" + Nome + '\'' +
                ", descrição='" + Descricao + '\'' +
                ", Data='" + Data + '\'' +
                ", Hora='" + Hora + '\'' +
                '}';
    }
}
