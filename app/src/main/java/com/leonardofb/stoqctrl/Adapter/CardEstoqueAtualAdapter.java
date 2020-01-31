package com.leonardofb.stoqctrl.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.service.autofill.TextValueSanitizer;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.leonardofb.stoqctrl.Classes.Material;
import com.leonardofb.stoqctrl.R;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.List;

public class CardEstoqueAtualAdapter extends RecyclerView.Adapter<CardEstoqueAtualAdapter.ViewHolder> {
    private Context context;
    private List<Material> ListaDeMateriais;

    public CardEstoqueAtualAdapter(Context context, List<Material> listaDeMateriais) {
        this.context = context;
        ListaDeMateriais = listaDeMateriais;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txt_nome_material_card, txt_lote_card, txt_validade_card, txt_tipo_card, txt_categoria_card, txt_codigo_card, txt_fornecedor_card, txt_cadastro_card, txt_qtdatual_qtdmin_card;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_nome_material_card = (TextView) itemView.findViewById(R.id.txt_nome_material_card);
            txt_lote_card = (TextView) itemView.findViewById(R.id.txt_lote_card);
            txt_validade_card = (TextView) itemView.findViewById(R.id.txt_validade_card);
            txt_tipo_card = (TextView) itemView.findViewById(R.id.txt_tipo_card);
            txt_categoria_card = (TextView) itemView.findViewById(R.id.txt_categoria_card);
            txt_codigo_card = (TextView) itemView.findViewById(R.id.txt_codigo_card);
            txt_fornecedor_card = (TextView) itemView.findViewById(R.id.txt_fornecedor_card);
            txt_cadastro_card = (TextView) itemView.findViewById(R.id.txt_cadastro_card);
            txt_qtdatual_qtdmin_card = (TextView) itemView.findViewById(R.id.txt_qtdatual_qtdmin_card);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.estoque_atual_card, parent, false);
        return new CardEstoqueAtualAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        @SuppressLint("SimpleDateFormat") Format formatter = new SimpleDateFormat("dd/MM/yyyy");

        holder.txt_nome_material_card.setText(ListaDeMateriais.get(position).getDescricao());
        holder.txt_lote_card.setText(String.format("LOTE: %s", ListaDeMateriais.get(position).getLote()));
        holder.txt_validade_card.setText(String.format("VALIDADE: %s", formatter.format(ListaDeMateriais.get(position).getValidade())));
        holder.txt_tipo_card.setText(String.format("TIPO: %s", ListaDeMateriais.get(position).getTipo()));
        holder.txt_categoria_card.setText(String.format("CATEGORIA: %s", ListaDeMateriais.get(position).getCategoria()));
        holder.txt_codigo_card.setText(String.format("CÓDIGO: %s", ListaDeMateriais.get(position).getCodigo()));
        holder.txt_fornecedor_card.setText(String.format("FORNECEDOR: %s", ListaDeMateriais.get(position).getFornecedor().getNomeFornecedor()));
        holder.txt_cadastro_card.setText(String.format("CADASTRO: %s", Integer.toString(position)));
        holder.txt_qtdatual_qtdmin_card.setText(String.format("QTD. ATUAL/MÍN: %s / %s", ListaDeMateriais.get(position).getQtdAtual(), ListaDeMateriais.get(position).getQtdMinima()));
        holder.txt_qtdatual_qtdmin_card.setTextColor(ListaDeMateriais.get(position).getQtdAtual() < ListaDeMateriais.get(position).getQtdMinima() ? Color.rgb(255, 0, 0) : Color.rgb(0, 0, 0));
    }

    @Override
    public int getItemCount() {
        return this.ListaDeMateriais.size();
    }
}
