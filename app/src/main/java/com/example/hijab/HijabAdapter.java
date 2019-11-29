package com.example.hijab;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hijab.entity.Hijab;

import java.util.List;

class HijabAdapter extends RecyclerView.Adapter<HijabAdapter.MyViewHolder> {

    private List<Hijab> hijabs;

    public HijabAdapter(List<Hijab> hijabs) {

        this.hijabs = hijabs;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hijab_item, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.mTextView.setText(hijabs.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return hijabs.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView mTextView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

              mTextView = itemView.findViewById(R.id.simple_text);

        }
    }
}
