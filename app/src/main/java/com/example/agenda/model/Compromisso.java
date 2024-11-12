package com.example.agenda.model;

public class Compromisso {
    private String Descricao;
    private String Data;
    private String Hora;


    public Compromisso(String descricao, String data, String hora){
        this.Descricao = descricao;
        this.Data = data;
        this.Hora = hora;
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

    public void setDescricao(String descricao){
        this.Descricao = descricao;
    }

    public void setData(String data){
        this.Data = data;
    }

    public void setHora(String hora){
        this.Hora = hora;
    }

    public String RetornaCompromisso() {
        return "Descrição:'" + Descricao + '\'' +
                ", Data: '" + Data + '\'' +
                ", Hora: '" + Hora + '\'' +
                '}';
    }
}
