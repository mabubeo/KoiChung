package com.example.tungnguyen.koichung.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.tungnguyen.koichung.ApiUntils;
import com.example.tungnguyen.koichung.R;
import com.example.tungnguyen.koichung.adapter.ListBatchAdapter;
import com.example.tungnguyen.koichung.model.Batch;
import com.example.tungnguyen.koichung.model.ListBatch;
import com.example.tungnguyen.koichung.remote.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListBatchActivity extends AppCompatActivity {

    RecyclerView rvListBatch;
    ListBatchAdapter adapterListBatch;
    List<Batch> data;
    ApiService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_batch);

        init();
        loadListBatch();
    }

    private void loadListBatch() {
        service.getListBatch("madara","madara").enqueue(new Callback<ListBatch>() {
            @Override
            public void onResponse(Call<ListBatch> call, Response<ListBatch> response) {
                if(response.isSuccessful()){
                        adapterListBatch.updateBatch(response.body().getResult());
                }
            }

            @Override
            public void onFailure(Call<ListBatch> call, Throwable t) {

            }
        });
    }

    private void init() {
        service = ApiUntils.getApiService();
        rvListBatch = findViewById(R.id.rv_list_batch);
        data = new ArrayList<>();

        LinearLayoutManager manager = new LinearLayoutManager(
                ListBatchActivity.this,
                LinearLayoutManager.VERTICAL,
                false);
        rvListBatch.setLayoutManager(manager);
        rvListBatch.setHasFixedSize(true);
        rvListBatch.setItemAnimator(new DefaultItemAnimator());
        DividerItemDecoration decoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        rvListBatch.addItemDecoration(decoration);
        adapterListBatch = new ListBatchAdapter(ListBatchActivity.this, data, new ListBatchAdapter.ListBatchItemListener() {
            @Override
            public void onBatchItemClick(Batch b) {
                Intent intent = new Intent(ListBatchActivity.this,ListBatchDetailActivity.class);
                intent.putExtra("batch",b);
                startActivity(intent);
            }
        });
        rvListBatch.setAdapter(adapterListBatch);
    }
}
