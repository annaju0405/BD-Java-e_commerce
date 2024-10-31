package com.mycompany.teste.entidade;

import java.util.Date;

public class Pagamento {
    private int pagamentoId;
    private int vendaId;
    private Date dataPagamento;
    private double valor;
    private String metodoPagamento;
    private String status;

    // Getters e Setters
    public int getPagamentoId() {
        return pagamentoId;
    }
    public void setPagamentoId(int pagamentoId) {
        this.pagamentoId = pagamentoId;
    }
    public int getVendaId() {
        return vendaId;
    }
    public void setVendaId(int vendaId) {
        this.vendaId = vendaId;
    }
    public Date getDataPagamento() {
        return dataPagamento;
    }
    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public String getMetodoPagamento() {
        return metodoPagamento;
    }
    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
