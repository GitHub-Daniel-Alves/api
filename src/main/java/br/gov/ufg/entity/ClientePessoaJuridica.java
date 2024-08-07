package br.gov.ufg.entity;

import java.io.Serializable;

public class ClientePessoaJuridica extends Cliente implements Serializable{
    private String cnpj;
    private String razaoSocial;
    private String inscricaoEstadual;

    public ClientePessoaJuridica(int idCliente, String nome, String email, String endereço, String telefone, String userName, String password, String cnpj, String razaoSocial, String inscricaoEstadual) {
        super(idCliente, nome, email, endereço, telefone, userName, password);
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.inscricaoEstadual = inscricaoEstadual;
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

    @Override
    public boolean login(String userName, String password){
        //verifica se o nome e a senha correspondem a esse cliente
        return userName.equals(getUserName()) && password.equals(getPassword());
    }

    @Override
    public void atualizaDados(Cliente cliente){
        setNome(cliente.getNome());
        setEmail(cliente.getEmail());
        setEndereço(cliente.getEndereço());
        setTelefone(cliente.getTelefone());
        setUserName(cliente.getUserName());
        setPassword(cliente.getPassword());
    }

    public boolean validarCNPJ(String cnpj){
        return cnpj.equals(getCnpj());
    }
}