package com.leonardofb.stoqctrl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.leonardofb.stoqctrl.Classes.Fornecedor;
import com.leonardofb.stoqctrl.Classes.Material;
import com.leonardofb.stoqctrl.Classes.Requisitante;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btn_cadastra_material, btn_cadastra_requisitante, btn_cadastra_fornecedor, btn_estoque;
    public static List<Material> material = new ArrayList<>();
    public static List<Fornecedor> fornecedor = new ArrayList<>();
    public static List<Requisitante> requisitante = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fornecedor.add(new Fornecedor("UNILEVER", "Leonardo"));
        fornecedor.add(new Fornecedor("BAYER", "THAYS"));

        material.add(new Material("LUVAS", "02", new Date(2020, 01, 01), "CGI", "EQUIPAMENTO", "2121", fornecedor.get(0), 10, 10));
        material.add(new Material("CAPACETE", "10", new Date(2020, 02, 02), "CGI", "EQUIPAMENTO", "3596", fornecedor.get(0), 20, 30));
        material.add(new Material("SABAO EM PÓ", "01", new Date(2020, 05, 02), "CGI", "MATERIAL", "3596", fornecedor.get(1), 30, 20));

        requisitante.add(new Requisitante("THAYS", "ALMOXERIFADO"));

        btn_cadastra_material = (Button) findViewById(R.id.btn_cadastra_material);
        btn_cadastra_requisitante = (Button) findViewById(R.id.btn_cadastra_requisitante);
        btn_cadastra_fornecedor = (Button) findViewById(R.id.btn_cadastra_fornecedor);
        btn_estoque = (Button) findViewById(R.id.btn_estoque);

        btn_cadastra_material.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CadastroMaterial.class);
                startActivity(intent);
            }
        });

        btn_cadastra_requisitante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CadastroRequisitante.class);
                startActivity(intent);
            }
        });

        btn_cadastra_fornecedor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CadastroFornecedor.class);
                startActivity(intent);
            }
        });

        btn_estoque.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, EstoqueAtual.class);
                startActivity(intent);
            }
        });
    }
}
