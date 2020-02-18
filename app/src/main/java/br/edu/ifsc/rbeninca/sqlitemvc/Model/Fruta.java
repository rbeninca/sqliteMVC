package br.edu.ifsc.rbeninca.sqlitemvc.Model;

public  class Fruta {

    Integer id;
    String nome;
    String tipo;

    public Fruta(String nome, String tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    public Fruta(Integer id, String nome, String tipo) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
