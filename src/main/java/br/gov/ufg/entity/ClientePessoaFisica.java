package br.gov.ufg.entity;
import java.util.Date;
import java.io.Serializable;

public class ClientePessoaFisica extends Cliente implements Serializable{
    private String cpf;
    private String rg;
    private Date dataNascimento;

    public ClientePessoaFisica(int idCliente, String nome, String email, String endereço, String telefone, String userName, String password, String cpf, Date dataNascimento, String rg) {
        super(idCliente, nome, email, endereço, telefone, userName, password);
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.rg = rg;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public boolean validarCPF(String cpf){
        //verifica se o cpf é o do cliente
        return cpf.equals(getCpf());
    }
}