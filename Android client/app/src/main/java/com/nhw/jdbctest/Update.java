package com.nhw.jdbctest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
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

public class Update extends AppCompatActivity {

    EditText edt_pw, edt_email;
    Button btn_update;
    ImageView img_back1;

    RequestQueue rq;
    StringRequest srq;
    Intent intent;

    String id, pw, email, name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        edt_pw = findViewById(R.id.edt_pw);
        edt_email = findViewById(R.id.edt_email);
        btn_update = findViewById(R.id.btn_update);
        img_back1 = findViewById(R.id.imv_back1);

        intent=getIntent();
        id = intent.getStringExtra("id");
        name = intent.getStringExtra("name");

        img_back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        rq = Volley.newRequestQueue(this);
        String url = "http://61.80.106.120:8082/ProjectIL/Updatetest";
        srq = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("1")) {
                    Toast.makeText(getApplicationContext(), "정보수정 성공", Toast.LENGTH_SHORT).show();
                    intent = new Intent(Update.this, Mypage.class);
                    startActivity(intent);
                } else if (response.equals("-1")) {
                    Toast.makeText(getApplicationContext(), "정보수정 실패1", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "잘못된 접근입니다.", Toast.LENGTH_SHORT).show();
                }

            }
        },new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() {
                HashMap<String, String> data = new HashMap<>();
                data.put("pw", pw);
                data.put("email", email);
                data.put("id", id);

                return data;
            }
        };
        srq.setTag("MAIN");

        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pw = edt_pw.getText().toString();
                email = edt_email.getText().toString();

                if(pw.equals("") || email.equals("")){
                    Toast.makeText(getApplicationContext(), "빈칸을 채워주세요!", Toast.LENGTH_SHORT).show();
                }else{
                    rq.add(srq);
                }
            }
        });


    }
}