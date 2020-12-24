package com.nhw.jdbctest;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {

    Button btn_login, btn_join;
    EditText edt_id, edt_pw;
    Intent intent;

    RequestQueue rq;
    StringRequest srq;

    String id, pw, name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_login = findViewById(R.id.btn_login);
        btn_join = findViewById(R.id.btn_join);
        edt_id = findViewById(R.id.edt_id);
        edt_pw = findViewById(R.id.edt_pw);

        rq = Volley.newRequestQueue(this);

        String url = "http://61.80.106.120:8082/ProjectIL/Logintest";

//        String url = "http://61.80.106.120:8082/project3/LoginServiceController";

        srq = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.v("aaa", response);
                if (response.equals("fail")) {
                    Log.v("ddd:", "name :" + response);
                    Toast.makeText(getApplicationContext(), "id, pw 확인", Toast.LENGTH_SHORT).show();
                } else {
                    Log.v("bbb", response);
                    Toast.makeText(getApplicationContext(), "로그인 성공", Toast.LENGTH_SHORT).show();
                    intent = new Intent(Login.this, Mypage.class);
                    intent.putExtra("id", id);
                    intent.putExtra("name", response);
                    startActivity(intent);

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("err","err::");
            }
        }){
            @Override
            protected Map<String, String> getParams(){
                HashMap<String, String> data = new HashMap<>();
                data.put("id", id);
                data.put("pw", pw);

                return data;
            }
        };
        srq.setTag("MAIN");

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = edt_id.getText().toString();
                pw = edt_pw.getText().toString();



                if(id.equals("") || pw.equals("")){
                    Toast.makeText(getApplicationContext(), "id를 채워주세요", Toast.LENGTH_SHORT).show();
                }else{
                    rq.add(srq);
                }
            }
        });

        btn_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Login.this, Join.class);
                startActivity(intent);
            }
        });
    }
}