package com.nhw.jdbctest;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class PostEx {
    byte[] image;

    public PostEx(byte[] image){
        this.image=image;

    }

    public void main(String[] args) throws IOException {

        OkHttpClient client = new OkHttpClient();

        RequestBody body = new FormBody.Builder().add("key", image.toString()).build();
        Request request = new Request.Builder().url("http://'61.80.106.120:5000/and").post(body).build();
        Response response = client.newCall(request).execute();
        ResponseBody responseBody = response.body();
        String res = responseBody.toString();
        System.out.print(res);
    }
}


