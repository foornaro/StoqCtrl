package com.leonardofb.stoqctrl.Classes;

/**
 * Created by lfberardi on 29/01/2020.
 */

public class Fornecedor {
    private String NomeFornecedor;
    private String Contato;

    public Fornecedor(String nomeFornecedor, String contato) {
        NomeFornecedor = nomeFornecedor;
        Contato = contato;
    }

    public String getNomeFornecedor() {
        return NomeFornecedor;
    }

    public void setNomeFornecedor(String nomeFornecedor) {
        NomeFornecedor = nomeFornecedor;
    }

    public String getContato() {
        return Contato;
    }

    public void setContato(String contato) {
        Contato = contato;
    }
}
