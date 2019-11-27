package com.example.hijab;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hijab.entity.Hijab;

import java.util.List;

public class HijabListAdapter extends RecyclerView.Adapter<HijabListAdapter.HijabViewHolder> {
    private List<Hijab> hijabList;



    // Provide a suitable constructor (depends on the kind of dataset)
    public HijabListAdapter(List<Hijab> hijabList) {
        this.hijabList = hijabList;
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public HijabListAdapter.HijabViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.hijab_item, parent, false);
        return new HijabViewHolder(v);

    }

    @Override
    public void onBindViewHolder(HijabViewHolder holder, int position) {
        holder.hijab_text.setText(hijabList.get(position).getName());

    }


    @Override
    public int getItemCount() {
        return hijabList.size();
    }


    class HijabViewHolder extends RecyclerView.ViewHolder {

        TextView hijab_text;

        HijabViewHolder(View itemView) {
            super(itemView);
            hijab_text = (TextView) itemView.findViewById(R.id.simple_text);

        }


    }
}

