package com.leonardofb.stoqctrl.Classes;

import android.media.Image;

/**
 * Created by lfberardi on 27/01/2020.
 */

public class Requisitante {

    private String Nome;
    private String Setor;
    private Image Foto;

    public Requisitante(String nome, String setor) {
        Nome = nome;
        Setor = setor;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getSetor() {
        return Setor;
    }

    public void setSetor(String setor) {
        Setor = setor;
    }

    public Image getFoto() {
        return Foto;
    }

    public void setFoto(Image foto) {
        Foto = foto;
    }
}
