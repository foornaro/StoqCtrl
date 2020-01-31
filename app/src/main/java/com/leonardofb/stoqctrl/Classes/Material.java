package com.leonardofb.stoqctrl.Classes;

import java.util.Date;

/**
 * Created by lfberardi on 27/01/2020.
 */

public class Material {

    private String Descricao;
    private String Lote;
    private Date Validade;
    private String Tipo;
    private String Categoria;
    private String Codigo;
    private int QtdAtual;
    private int QtdMinima;
    private Fornecedor Fornecedor;
    private long id;

    public Material(String descricao, String lote, Date validade, String tipo, String categoria, String codigo, Fornecedor fornecedor, int qtdAtual, int qQtdMinima) {
        Descricao = descricao;
        Lote = lote;
        Validade = validade;
        Tipo = tipo;
        Categoria = categoria;
        Codigo = codigo;
        Fornecedor = fornecedor;
        QtdAtual = qtdAtual;
        QtdMinima = qQtdMinima;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }

    public String getLote() {
        return Lote;
    }

    public void setLote(String lote) {
        Lote = lote;
    }

    public Date getValidade() {
        return Validade;
    }

    public void setValidade(Date validade) {
        Validade = validade;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String codigo) {
        Codigo = codigo;
    }

    public Fornecedor getFornecedor() {
        return Fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        Fornecedor = fornecedor;
    }

    public int getQtdAtual() {
        return QtdAtual;
    }

    public void setQtdAtual(int qtdAtual) {
        QtdAtual = qtdAtual;
    }

    public int getQtdMinima() {
        return QtdMinima;
    }

    public void setQtdMinima(int qtdMinima) {
        QtdMinima = qtdMinima;
    }
}
