package com.example.tungnguyen.koichung.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.tungnguyen.koichung.R;
import com.example.tungnguyen.koichung.model.Batch;

import java.util.List;

public class ListBatchAdapter extends RecyclerView.Adapter<ListBatchAdapter.ViewHolder> {
    Context context;
    List<Batch> data;
    ListBatchItemListener listener;


    public ListBatchAdapter(Context context, List<Batch> data, ListBatchItemListener listener) {
        this.context = context;
        this.data = data;
        this.listener = listener;
    }

    public void updateBatch(List<Batch> batches){
        data = batches;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_listbatch,viewGroup,false);
        return new ViewHolder(view,this.listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Batch batch = data.get(i);
        viewHolder.tvCode.setText(batch.getCode());
        viewHolder.tvCount.setText(batch.getCount()+"");
        viewHolder.tvRoot.setText(batch.getRoot());
        viewHolder.tvDealer.setText(batch.getDealer());
        viewHolder.tvBuyer.setText(batch.getBuyer());
        viewHolder.tvPrivateNode.setText(batch.getPrivateNote());
        viewHolder.tvNode.setText(batch.getNote());
        viewHolder.tvCreateDate.setText(batch.getCreateDate());
        viewHolder.tvRoot.setText(batch.getRoot());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tvCode,tvCount,tvRoot,tvDealer,tvBuyer,tvPrivateNode,tvNode,tvCreateDate;
        ListBatchItemListener listener;

        public ViewHolder(@NonNull View itemView,ListBatchItemListener listener) {
            super(itemView);
            tvCode = itemView.findViewById(R.id.tv_code);
            tvCount = itemView.findViewById(R.id.tv_count);
            tvRoot = itemView.findViewById(R.id.tv_root);
            tvDealer = itemView.findViewById(R.id.tv_dealer);
            tvBuyer = itemView.findViewById(R.id.tv_buyer);
            tvPrivateNode = itemView.findViewById(R.id.tv_private_note);
            tvNode = itemView.findViewById(R.id.tv_node);
            tvCreateDate = itemView.findViewById(R.id.tv_create_date);

            this.listener = listener;
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            Batch b = getBatch(getAdapterPosition());
            this.listener.onBatchItemClick(b);
            notifyDataSetChanged();
        }
    }

    public interface ListBatchItemListener {
        void onBatchItemClick(Batch b);
    }

    private Batch getBatch(int adapterPosition) {
        return data.get(adapterPosition);
    }

}
