package com.example.tungnguyen.koichung.remote;

import com.example.tungnguyen.koichung.model.Batch;
import com.example.tungnguyen.koichung.model.ListBatch;
import com.example.tungnguyen.koichung.model.detail.Detail;
import com.example.tungnguyen.koichung.model.detail.ListimageConfirm;
import com.example.tungnguyen.koichung.model.detail.Result;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {

    @POST("/api/Service/CheckLogin")
    @FormUrlEncoded
    Call<JsonObject> checkLogin(@Field("userAPI") String userApi,
                                @Field("passAPI") String passApi,
                                @Field("username") String username,
                                @Field("password") String password);

    @POST("/api/Service/GetListBatch")
    @FormUrlEncoded
    Call<ListBatch> getListBatch(@Field("userAPI") String userApi,
                                 @Field("passAPI") String passApi);

    @POST("/api/Service/GetBatchDetail")
    @FormUrlEncoded
    Call<Detail> getDetail(@Field("userAPI") String userApi,
                                     @Field("passAPI") String passApi,
                                     @Field("ID") String id);
}
