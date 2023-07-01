package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CorreoAdapter extends RecyclerView.Adapter<CorreoAdapter.ViewHolder> {
    List<Usuario> listaUsuarios;

    public CorreoAdapter(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item, parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Usuario usuario = listaUsuarios.get(position);
        String fullname = usuario.getNombres()+ "" +usuario.getApellidos();
        holder.tvRemitente.setText(fullname);
        holder.tvAsunto.setText(usuario.getTipo());
        holder.tvMensaje.setText(usuario.getUsername());
    }


    @Override
    public int getItemCount() {
        return  listaUsuarios.size();

    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvRemitente;
        TextView tvAsunto;
        TextView tvMensaje;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvRemitente = itemView.findViewById(R.id.tvRemitente);
            tvAsunto = itemView.findViewById(R.id.tvAsunto);
            tvMensaje = itemView.findViewById(R.id.tvResumen);
        }
    }
}