package com.example.tungnguyen.koichung;

import com.example.tungnguyen.koichung.remote.ApiService;
import com.example.tungnguyen.koichung.remote.RetrofitClient;

public class ApiUntils {
    public static final String BASE_URL = "http://winds.hopto.org/";

    public static ApiService getApiService(){
        return RetrofitClient.getClient(BASE_URL).create(ApiService.class);
    }
}
