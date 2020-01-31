package com.leonardofb.stoqctrl;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;
import com.leonardofb.stoqctrl.Classes.Fornecedor;
import com.leonardofb.stoqctrl.Classes.Material;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;

public class CadastroMaterial extends AppCompatActivity {
    private EditText txt_validade, txt_descricao, txt_lote, txt_tipo, txt_categoria, txt_codigo, txt_qtd_atual, txt_qtd_min;
    private AutoCompleteTextView txt_fornecedor;
    private Button btn_confirma_cadastro_material;
    final Locale myLocale = new Locale("pt", "PT");
    private final Calendar myCalendar = Calendar.getInstance(myLocale);
    private HashMap<String, Fornecedor> HashFornecedor = new HashMap<>();

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_material);

        txt_validade = (EditText) findViewById(R.id.txt_validade);
        txt_descricao = (EditText) findViewById(R.id.txt_descricao);
        txt_lote = (EditText) findViewById(R.id.txt_lote);
        txt_validade = (EditText) findViewById(R.id.txt_validade);
        txt_tipo = (EditText) findViewById(R.id.txt_tipo);
        txt_categoria = (EditText) findViewById(R.id.txt_categoria);
        txt_codigo = (EditText) findViewById(R.id.txt_codigo);
        txt_qtd_atual = (EditText) findViewById(R.id.txt_qtd_atual);
        txt_qtd_min = (EditText) findViewById(R.id.txt_qtd_min);
        txt_fornecedor = (AutoCompleteTextView) findViewById(R.id.txt_fornecedor);
        btn_confirma_cadastro_material = (Button) findViewById(R.id.btn_confirma_cadastro_material);

        //region Adicionando os fornecedores ao edittext
        String[] listaFornecedores = new String[MainActivity.fornecedor.size()];
        int count = 0;
        for (Fornecedor forn : MainActivity.fornecedor) {
            HashFornecedor.put(forn.getNomeFornecedor(), forn);
            listaFornecedores[count] = forn.getNomeFornecedor();
            count++;
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.select_dialog_singlechoice, listaFornecedores);
        txt_fornecedor.setThreshold(1);
        txt_fornecedor.setAdapter(adapter);


        txt_fornecedor.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    txt_fornecedor.showDropDown();

            }
        });

        txt_fornecedor.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                txt_fornecedor.showDropDown();
                return false;
            }
        });

        //endregion

        //region Adionando o calendario ao edittex
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };

        txt_validade.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(CadastroMaterial.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        //endregion

        //region Adicionando o click do botão
        btn_confirma_cadastro_material.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String erros = "";
                erros += !txt_descricao.getText().toString().equals("") ? "" : getString(R.string.insira_descricao) + "\n";
                erros += !txt_lote.getText().toString().equals("") ? "" : getString(R.string.insira_lote) + "\n";
                erros += !txt_validade.getText().toString().equals("") ? "" : getString(R.string.insira_validade) + "\n";
                erros += !txt_tipo.getText().toString().equals("") ? "" : getString(R.string.insira_tipo) + "\n";
                erros += !txt_categoria.getText().toString().equals("") ? "" : getString(R.string.insira_categoria) + "\n";
                erros += !txt_codigo.getText().toString().equals("") ? "" : getString(R.string.insira_codigo) + "\n";
                erros += !txt_qtd_atual.getText().toString().equals("") ? "" : getString(R.string.insira_atual) + "\n";
                erros += !txt_qtd_min.getText().toString().equals("") ? "" : getString(R.string.insira_minima) + "\n";
                erros += HashFornecedor.containsKey(txt_fornecedor.getText().toString()) ? "" : getString(R.string.selecionar_fornecedor) + "\n";
                if (erros.equals("")) {
                    try {
                        MainActivity.material.add(new Material(
                                txt_descricao.getText().toString().toUpperCase(),
                                txt_lote.getText().toString().toUpperCase(),
                                myCalendar.getTime(),
                                txt_tipo.getText().toString().toUpperCase(),
                                txt_categoria.getText().toString().toUpperCase(),
                                txt_codigo.getText().toString().toUpperCase(),
                                HashFornecedor.get(txt_fornecedor.getText().toString()),
                                Integer.parseInt(txt_qtd_atual.getText().toString()),
                                Integer.parseInt(txt_qtd_min.getText().toString())));
                        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(CadastroMaterial.this);
                        alertDialog.setTitle(R.string.sucesso_cadastrar_material);
                        alertDialog.setMessage(erros);
                        alertDialog.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                txt_descricao.setText("");
                                txt_lote.setText("");
                                txt_validade.setText("");
                                txt_tipo.setText("");
                                txt_categoria.setText("");
                                txt_codigo.setText("");
                                txt_fornecedor.setText("");
                                txt_qtd_atual.setText("");
                                txt_qtd_min.setText("");
                            }
                        });
                        alertDialog.show();
                    } catch (Exception e) {
                        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(CadastroMaterial.this);
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
                    final AlertDialog.Builder alertDialog = new AlertDialog.Builder(CadastroMaterial.this);
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

    private void updateLabel() {
        String myFormat = "dd/MM/yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, myLocale);

        txt_validade.setText(sdf.format(myCalendar.getTime()));
    }
}
