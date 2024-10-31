
package com.mycompany.teste.entidade;

import java.util.Date;

public class Venda {
    private int vendaId;
    private int clienteId;
    private Date dataVenda;
    private int statusPedidoId;
    private double valorTotal;

    // Getters e Setters
    public int getVendaId() {
        return vendaId;
    }
    public void setVendaId(int vendaId) {
        this.vendaId = vendaId;
    }
    public int getClienteId() {
        return clienteId;
    }
    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }
    public Date getDataVenda() {
        return dataVenda;
    }
    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }
    public int getStatusPedidoId() {
        return statusPedidoId;
    }
    public void setStatusPedidoId(int statusPedidoId) {
        this.statusPedidoId = statusPedidoId;
    }
    public double getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
