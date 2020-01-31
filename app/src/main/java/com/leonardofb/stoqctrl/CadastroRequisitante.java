package com.leonardofb.stoqctrl;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.leonardofb.stoqctrl.Classes.Fornecedor;
import com.leonardofb.stoqctrl.Classes.Requisitante;

public class CadastroRequisitante extends AppCompatActivity {
    private EditText txt_nome_requisitante, txt_setor_requisitante;
    private Button btn_confirma_cadastro_requisitante;
    private ImageButton img_btn_cadastra_foto_requisitante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_requisitante);

        txt_nome_requisitante = (EditText) findViewById(R.id.txt_nome_requisitante);
        txt_setor_requisitante = (EditText) findViewById(R.id.txt_setor_requisitante);
        btn_confirma_cadastro_requisitante = (Button) findViewById(R.id.btn_confirma_cadastro_requisitante);
        img_btn_cadastra_foto_requisitante = (ImageButton) findViewById(R.id.img_btn_cadastra_foto_requisitante);

        img_btn_cadastra_foto_requisitante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CadastroRequisitante.this, "FUNCIONALIDADE INDISPONÍVEL NO MOMENTO!", Toast.LENGTH_SHORT).show();
            }
        });

        btn_confirma_cadastro_requisitante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String erros = "";
                erros += !txt_nome_requisitante.getText().toString().equals("") ? "" : getString(R.string.insira_requisitante) + "\n";
                erros += !txt_setor_requisitante.getText().toString().equals("") ? "" : getString(R.string.insira_setor) + "\n";
                if (erros.equals("")) {
                    try {
                        MainActivity.requisitante.add(new Requisitante(
                                txt_nome_requisitante.getText().toString().toUpperCase(),
                                txt_setor_requisitante.getText().toString().toUpperCase()));
                        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(CadastroRequisitante.this);
                        alertDialog.setTitle(R.string.sucesso_cadastrar_requisitante);
                        alertDialog.setMessage(erros);
                        alertDialog.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                txt_nome_requisitante.setText("");
                                txt_setor_requisitante.setText("");
                            }
                        });
                        alertDialog.show();
                    } catch (Exception e) {
                        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(CadastroRequisitante.this);
                        alertDialog.setTitle(R.string.erro_cadastrar);
                        alertDialog.setMessage(getString(R.string.avise_adm_msg) + e.getMessage());
                        alertDialog.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        alertDialog.show();
                    }
                } else {
                    final AlertDialog.Builder alertDialog = new AlertDialog.Builder(CadastroRequisitante.this);
                    alertDialog.setTitle(R.string.erro_cadastrar);
                    alertDialog.setMessage(erros);
                    alertDialog.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    alertDialog.show();
                }
            }
        });
    }
}
