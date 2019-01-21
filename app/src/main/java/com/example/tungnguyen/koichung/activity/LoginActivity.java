package com.example.tungnguyen.koichung.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tungnguyen.koichung.ApiUntils;
import com.example.tungnguyen.koichung.R;
import com.example.tungnguyen.koichung.remote.ApiService;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    public static final String BASE_URL="http://winds.hopto.org/";
    private static final String TAG = "abc";

    Retrofit retrofit;
    ApiService service;

    EditText etUserName,etPassword;
    Button btLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();
        event();
    }

    private void event() {
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    private void init() {
        etPassword = findViewById(R.id.et_password);
        etUserName = findViewById(R.id.et_username);
        btLogin = findViewById(R.id.bt_login);
    }

    void login(){
        ProgressDialog dialog = new ProgressDialog(this);
        dialog.setMessage("Loading. Please wait ...");
        dialog.show();

       service = ApiUntils.getApiService();

        service.checkLogin("madara",
                "madara",
                etUserName.getText().toString(),
                etPassword.getText().toString()).
                enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                        if(response.isSuccessful()){
                            //String result = ;
                            String tmp= response.body().toString();
                            try {
                                JSONObject jsonObject = new JSONObject(tmp);
                                Log.d(TAG, "onResponse: " + jsonObject.get("code"));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            Log.d(TAG, "onResponse: " + response.body().toString());
                            //Toast.makeText(LoginActivity.this, "Login succsess", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(LoginActivity.this,ListBatchActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }

                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {
                        Log.d("MainActivity", "error loading from API");
                    }
                });

    }
}
