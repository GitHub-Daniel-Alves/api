package br.gov.ufg.entity;

public abstract class Cliente {
    private int idCliente;
    private String nome;
    private String email;
    private String endereço;
    private String telefone;
    private String userName;
    private String password;

    public Cliente(int idCliente, String nome, String email, String endereço, String telefone, String userName, String password) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.email = email;
        this.endereço = endereço;
        this.telefone = telefone;
        this.userName = userName;
        this.password = password;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
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

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public abstract boolean login(String userName, String password);

    public abstract void atualizaDados(Cliente cliente);
}
