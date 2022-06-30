package br.ufjf.dcc196.izabel.avistamentos;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AvistamentoAdapter extends RecyclerView.Adapter<AvistamentoAdapter.AvistamentoViewHolder> {
    private List<Avistamento> avistamentos;

    public AvistamentoAdapter(List<Avistamento> avistamentos) {
        this.avistamentos = avistamentos;
    }

    @NonNull
    @Override
    public AvistamentoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull AvistamentoViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class AvistamentoViewHolder extends RecyclerView.ViewHolder{

        public AvistamentoViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
