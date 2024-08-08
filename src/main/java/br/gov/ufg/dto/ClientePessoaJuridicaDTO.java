package br.gov.ufg.dto;

public class ClientePessoaJuridicaDTO {
    private int idCliente;
    private String nome;
    private String email;
    private String endereço;
    private String telefone;
    private String userName;
    private String password;
    private String cnpj;
    private String razaoSocial;
    private String inscricaoEstadual;

    public ClientePessoaJuridicaDTO() {
    }

    public ClientePessoaJuridicaDTO(int idCliente, String nome, String email, String endereço, String telefone, String userName, String password, String cnpj, String razaoSocial, String inscricaoEstadual) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.email = email;
        this.endereço = endereço;
        this.telefone = telefone;
        this.userName = userName;
        this.password = password;
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.inscricaoEstadual = inscricaoEstadual;
    }

    // Getters e Setters

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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }
}
