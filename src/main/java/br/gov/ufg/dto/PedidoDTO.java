package br.gov.ufg.dto;

import java.util.Date;

public class PedidoDTO {
    private int idPedido;
    private Date dataPedido;
    private String status;

    public PedidoDTO() {
    }

    public PedidoDTO(int idPedido, Date dataPedido, String status) {
        this.idPedido = idPedido;
        this.dataPedido = dataPedido;
        this.status = status;
    }

    // Getters e Setters

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
