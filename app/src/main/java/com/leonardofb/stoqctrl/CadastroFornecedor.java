package com.leonardofb.stoqctrl;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.leonardofb.stoqctrl.Classes.Fornecedor;
import com.leonardofb.stoqctrl.Classes.Material;

public class CadastroFornecedor extends AppCompatActivity {

    private EditText txt_nome_fornecedor, txt_contato_fornecedor;
    private Button btn_confirma_cadastro_fornecedor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_fornecedor);
        txt_nome_fornecedor = (EditText) findViewById(R.id.txt_nome_fornecedor);
        txt_contato_fornecedor = (EditText) findViewById(R.id.txt_contato_fornecedor);
        btn_confirma_cadastro_fornecedor = (Button) findViewById(R.id.btn_confirma_cadastro_fornecedor);

        //region Adicionando o click do botão
        btn_confirma_cadastro_fornecedor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String erros = "";
                erros += !txt_nome_fornecedor.getText().toString().equals("") ? "" : getString(R.string.insira_fornecedor) + "\n";
                erros += !txt_contato_fornecedor.getText().toString().equals("") ? "" : getString(R.string.insira_contato) + "\n";
                if (erros.equals("")) {
                    try {
                        MainActivity.fornecedor.add(new Fornecedor(
                                txt_nome_fornecedor.getText().toString().toUpperCase(),
                                txt_nome_fornecedor.getText().toString().toUpperCase()));
                        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(CadastroFornecedor.this);
                        alertDialog.setTitle(R.string.sucesso_cadastrar_fornecedor);
                        alertDialog.setMessage(erros);
                        alertDialog.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                txt_nome_fornecedor.setText("");
                                txt_contato_fornecedor.setText("");
                            }
                        });
                        alertDialog.show();
                    } catch (Exception e) {
                        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(CadastroFornecedor.this);
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
                    final AlertDialog.Builder alertDialog = new AlertDialog.Builder(CadastroFornecedor.this);
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
        //endregion
    }
}
