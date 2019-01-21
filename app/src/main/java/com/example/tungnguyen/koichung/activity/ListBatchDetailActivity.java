package com.example.tungnguyen.koichung.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.example.tungnguyen.koichung.ApiUntils;
import com.example.tungnguyen.koichung.R;
import com.example.tungnguyen.koichung.adapter.ListBatchDetailAdapter;
import com.example.tungnguyen.koichung.model.Batch;
import com.example.tungnguyen.koichung.model.DoubleImage;
import com.example.tungnguyen.koichung.model.detail.Detail;
import com.example.tungnguyen.koichung.model.detail.ListimageConfirm;
import com.example.tungnguyen.koichung.model.detail.Result;
import com.example.tungnguyen.koichung.remote.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListBatchDetailActivity extends AppCompatActivity {
    RecyclerView rvBatchDetail;
    List<ListimageConfirm> imageList;
    List<DoubleImage> doubleImages;
    List<Object> batchDetail;
    ApiService service;
    Result result;
    ListBatchDetailAdapter adapter;
    Batch batch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_batch_detail);

        init();
        loadData();
    }

    private List<DoubleImage> convertToDoubleImage(List<ListimageConfirm> list){
        List<DoubleImage> doubleImages = new ArrayList<>();
        boolean toggle =true;
        DoubleImage doubleImage = new DoubleImage();
        for(ListimageConfirm data : list){
            if(toggle){
                doubleImage = new DoubleImage();
                doubleImage.setImageFirst(data);
                toggle = false;
            }else{
                doubleImage.setImageSecond(data);
                toggle = true;
            }
            if(toggle) doubleImages.add(doubleImage);
        }
        return doubleImages;
    }


    private void loadData() {
        Intent intent = getIntent();
        if(intent !=null){
            if(intent.hasExtra("batch")){
                batch = (Batch) intent.getExtras().getSerializable("batch");
                int id = batch.getId();
                service.getDetail("madara",
                        "madara",
                        id+"").enqueue(new Callback<Detail>() {
                    @Override
                    public void onResponse(Call<Detail> call, Response<Detail> response) {
                        result = response.body().getResult();
                        imageList = result.getListimageConfirm();
                        doubleImages = convertToDoubleImage(imageList);
                        initRecycleView();
                    }

                    @Override
                    public void onFailure(Call<Detail> call, Throwable t) {

                    }
                });
            }
        }

    }

    private void initRecycleView() {
        batchDetail = new ArrayList<>();
        batchDetail.add(result);
        batchDetail.add("Confirm image");
        batchDetail.addAll(doubleImages);
        adapter = new ListBatchDetailAdapter(this,batchDetail);
        rvBatchDetail.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        rvBatchDetail.setAdapter(adapter);
    }

    private void init() {
        service = ApiUntils.getApiService();
        rvBatchDetail = findViewById(R.id.rv_batch_detail);

//        GridLayoutManager manager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
//        //adapter = new ListBatchDetailAdapter(this,data);
//        rvBatchDetail.setLayoutManager(manager);
//        rvBatchDetail.setAdapter(adapter);
    }
}
