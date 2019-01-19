package com.example.henry.trytolenrnactivity;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public  class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {
    private List<Book> mybooklist;
    static class ViewHolder extends RecyclerView.ViewHolder{
        LinearLayout glodenlayout;
        LinearLayout pinklayout;
        TextView glodenText;
        TextView pinkText;

        public ViewHolder(View view){
            super(view);
            glodenlayout =  view.findViewById(R.id.gloden_view);
            pinklayout =  view.findViewById(R.id.pink_view);
            glodenText = view.findViewById(R.id.text_viewr);
            pinkText = view.findViewById(R.id.text_viewl);
        }
    }
    public BookAdapter(List<Book> bookList){
        mybooklist = bookList;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view,parent,false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final  int PINK_COlOR = 0;
        final int BLUE_COLOR = 1;
        Book book = mybooklist.get(position);
        if(book.getType() ==PINK_COlOR ){
            holder.pinklayout.setVisibility(View.VISIBLE);
            holder.glodenlayout.setVisibility(View.GONE);
            holder.pinkText.setText(book.getName());
        }else if(book.getType()==BLUE_COLOR){
            holder.glodenlayout.setVisibility(View.VISIBLE);
            holder.pinklayout.setVisibility(View.GONE);
            holder.glodenText.setText(book.getName());
        }
    }
    @Override
    public int getItemCount(){
        return mybooklist.size();
    }
    @Override
    public int getItemViewType(int position){
        return position;
    }
}