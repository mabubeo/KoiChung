package com.example.tungnguyen.koichung.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tungnguyen.koichung.R;
import com.example.tungnguyen.koichung.model.DoubleImage;
import com.example.tungnguyen.koichung.model.detail.ListimageConfirm;
import com.example.tungnguyen.koichung.model.detail.Result;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ListBatchDetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int TYPE_HEADER = 0;
    public static final int TYPE_SECTION = 1;
    public static final int TYPE_IMAGE = 2;


    Context context;
    List<Object> data;

    public ListBatchDetailAdapter(Context context, List<Object> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        if(i == TYPE_HEADER){
            view = LayoutInflater.from(context).inflate(R.layout.item_header,viewGroup,false);
            return new HeaderHolder(view);
        } else if(i == TYPE_SECTION){
            view = LayoutInflater.from(context).inflate(R.layout.item_section_name,viewGroup,false);
            return new SectionNameHolder(view);
        } else{
            view = LayoutInflater.from(context).inflate(R.layout.item_row_image,viewGroup,false);
            return new ImageHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        switch (viewHolder.getItemViewType()){
            case TYPE_HEADER:
                ((HeaderHolder) viewHolder).bindData((Result) data.get(i));
                break;
            case TYPE_SECTION:
                ((SectionNameHolder) viewHolder).bindData((String) data.get(i));
                break;
            case TYPE_IMAGE:
                ((ImageHolder) viewHolder).bindData((DoubleImage) data.get(i));
                break;

        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0 ) return TYPE_HEADER;
        else if(data.get(position) instanceof String) return TYPE_SECTION;
        if(data.get(position) instanceof DoubleImage) return TYPE_IMAGE;
        return TYPE_SECTION;
    }

    public class HeaderHolder extends RecyclerView.ViewHolder{
        TextView tvRoot,tvCount,tvCode,tvListCode;

        public HeaderHolder(@NonNull View itemView) {
            super(itemView);
            tvRoot = itemView.findViewById(R.id.tv_root_detail);
            tvCount = itemView.findViewById(R.id.tv_count_detail);
            tvCode = itemView.findViewById(R.id.tv_code_detail);
            tvListCode = itemView.findViewById(R.id.tv_list_code);
        }

        public void bindData(Result result){
            tvRoot.setText(result.getRoot());
            tvCount.setText(result.getCount()+"");
            tvCode.setText(result.getCode());
            tvListCode.setText(result.getCode());
        }
    }

    public class SectionNameHolder extends RecyclerView.ViewHolder{
        TextView tvSectionName;

        public SectionNameHolder(@NonNull View itemView) {
            super(itemView);
            tvSectionName = itemView.findViewById(R.id.tv_section_name);
        }

        public void bindData(String node){
            tvSectionName.setText(node);
        }
    }

    public class ImageHolder extends RecyclerView.ViewHolder{
        ImageView ivFirst,ivSecond;
        TextView tvUserNameFirst,tvDateDetailFirst,tvUserNameSecond,tvDateDetailSecond;

        public ImageHolder(@NonNull View itemView) {
            super(itemView);
            ivFirst = itemView.findViewById(R.id.iv_first);
            ivSecond = itemView.findViewById(R.id.iv_second);
            tvUserNameFirst = itemView.findViewById(R.id.tv_user_name_first);
            tvDateDetailFirst = itemView.findViewById(R.id.tv_date_detail_first);
            tvUserNameSecond = itemView.findViewById(R.id.tv_user_name_second);
            tvDateDetailSecond = itemView.findViewById(R.id.tv_date_detail_second);
        }

        public void bindData(DoubleImage doubleImage){
            if(doubleImage.getImageFirst() != null){
                tvUserNameFirst.setText(doubleImage.getImageFirst().getUserName());
                tvDateDetailFirst.setText(doubleImage.getImageFirst().getCreateDate());
                Picasso.get().load(doubleImage.getImageFirst().getUrl()).into(ivFirst);
            }
            if(doubleImage.getImageSecond() != null){
                tvUserNameSecond.setText(doubleImage.getImageSecond().getUserName());
                tvDateDetailSecond.setText(doubleImage.getImageSecond().getCreateDate());
                Picasso.get().load(doubleImage.getImageSecond().getUrl()).into(ivSecond);
            }
        }
    }
}
