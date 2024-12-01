package com.nbut.memorandum;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecycleBinAdapter extends RecyclerView.Adapter<RecycleBinAdapter.ViewHolder> {

    private final List<Note> deletedNotes;

    public RecycleBinAdapter(List<Note> deletedNotes) {
        this.deletedNotes = deletedNotes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycle_bin_item, parent, false);
        return new ViewHolder(view);
    }

//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        Note note = deletedNotes.get(position);
//        holder.title.setText(note.getTitle());
//        holder.content.setText(note.getContent());
//    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Note note = deletedNotes.get(position);
        holder.title.setText(note.getTitle());  // 获取标题
        holder.content.setText(note.getMainText());  // 获取内容
    }


    @Override
    public int getItemCount() {
        return deletedNotes.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, content;

        ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.note_title);
            content = itemView.findViewById(R.id.note_content);
        }
    }
}
