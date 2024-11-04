package model.entity;

public class User {
    private int id;
    private String nome;
    private String email;
    private String senha;

    public User(String oNome, String oEmail, String aSenha, int oId) {
        this.nome = oNome;
        this.email = oEmail;
        this.senha = aSenha;
        this.id = oId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}