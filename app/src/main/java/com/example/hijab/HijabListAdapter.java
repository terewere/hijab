package com.example.hijab;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hijab.entity.Hijab;

import java.util.List;

final class HijabListAdapter extends RecyclerView.Adapter<HijabListAdapter.HijabViewHolder> {

    final private List<Hijab> hijabList;

    public HijabListAdapter(List<Hijab> hijabs) {
        this.hijabList = hijabs;
    }

    @NonNull
    @Override
    public final HijabViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, final int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hijab_item, parent, false);
        return new HijabViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final HijabViewHolder holder, final int position) {

        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return hijabList.size();
    }

    final class HijabViewHolder extends RecyclerView.ViewHolder {

        TextView mTitle;

        public HijabViewHolder(@NonNull final View itemView) {
            super(itemView);

            mTitle = itemView.findViewById(R.id.simple_text);
        }

        public void bind(final int position) {
            mTitle.setText(hijabList.get(position).getName());
        }
    }
}
