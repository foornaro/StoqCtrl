package com.leonardofb.stoqctrl;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.leonardofb.stoqctrl.Adapter.CardEstoqueAtualAdapter;
import com.leonardofb.stoqctrl.Classes.Material;

import java.util.ArrayList;
import java.util.List;

public class EstoqueAtual extends AppCompatActivity {

    RecyclerView rv_estoque_atual;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.estoque_atual);


        rv_estoque_atual = (RecyclerView) findViewById(R.id.rv_estoque_atual);

        rv_estoque_atual.setLayoutManager(new LinearLayoutManager(this));
        CardEstoqueAtualAdapter amplificadorNoOpticoRec = new CardEstoqueAtualAdapter(this,  MainActivity.material);
        rv_estoque_atual.setAdapter(amplificadorNoOpticoRec);
    }
}
