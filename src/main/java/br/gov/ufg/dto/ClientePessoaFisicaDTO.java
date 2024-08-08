package br.gov.ufg.dto;

import java.util.Date;

public class ClientePessoaFisicaDTO {
    private int idCliente;
    private String nome;
    private String email;
    private String endereço;
    private String telefone;
    private String userName;
    private String password;
    private String cpf;
    private String rg;
    private Date dataNascimento;

    public ClientePessoaFisicaDTO() {
    }

    public ClientePessoaFisicaDTO(int idCliente, String nome, String email, String endereço, String telefone, String userName, String password, String cpf, Date dataNascimento, String rg) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.email = email;
        this.endereço = endereço;
        this.telefone = telefone;
        this.userName = userName;
        this.password = password;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.rg = rg;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
