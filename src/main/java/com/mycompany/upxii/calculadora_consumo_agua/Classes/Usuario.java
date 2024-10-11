
package com.mycompany.upxii.calculadora_consumo_agua.Classes;

public class Usuario {
    public int idUsuario;
    private String login;
    private String nome;
    private String email;
    private String senha;
    private int empresa;
    
    public Usuario(){
        
    }

    public Usuario(int idUsuario, String nome, String email, int empresa) { //Construtor para armazenar um ID
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.email = email;
        this.empresa = empresa;
    }
    
    
    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }
    

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

    public int getEmpresa() {
        return empresa;
    }

    public void setEmpresa(int empresa) {
        this.empresa = empresa;
    }

    public int getIdUsuario() { //Ao executar tudo o ID fica salvo dentro da variável e fica pronto para ser usado
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
}
