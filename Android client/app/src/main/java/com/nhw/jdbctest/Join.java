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

public class Join extends AppCompatActivity {

    EditText edt_id, edt_pw, edt_email, edt_name, edt_age, edt_gender;
    Button btn_join;
    Intent intent;

    RequestQueue rq;
    StringRequest srq;
    String id, pw, email, name, age, gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        edt_id = findViewById(R.id.edt_id);
        edt_pw = findViewById(R.id.edt_pw);
        edt_email = findViewById(R.id.edt_email);
        edt_name = findViewById(R.id.edt_name);
        edt_age = findViewById(R.id.edt_age);
        edt_gender = findViewById(R.id.edt_gender);

        btn_join = findViewById(R.id.btn_join);

        rq = Volley.newRequestQueue(this);

        String url = "http://61.80.106.120:8082/ProjectIL/test";

        srq = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("1")) {
                    // out.print값으로 되돌려받은 preparedstatement.executeUpdate()의 결과값
                    Toast.makeText(getApplicationContext(), "회원가입 성공", Toast.LENGTH_SHORT).show();
                    intent = new Intent(Join.this, Login.class);
                    startActivity(intent);
                } else if (response.equals("-1")) { // SQLException
                    Toast.makeText(getApplicationContext(), "회원가입 실패, 중복 된 아이디입니다.", Toast.LENGTH_SHORT).show();
                } else { // 기타 Exception
                    Toast.makeText(getApplicationContext(), "잘못된 접근입니다.", Toast.LENGTH_SHORT).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                HashMap<String, String> data = new HashMap<>();
                data.put("id", id);
                data.put("pw", pw);
                data.put("email", email);
                data.put("name", name);
                data.put("age", age);
                data.put("gender", gender);

                return data;


            }
        };
        srq.setTag("MAIN");

        btn_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = edt_id.getText().toString();
                pw = edt_pw.getText().toString();
                email = edt_email.getText().toString();
                name = edt_name.getText().toString();
                age = edt_age.getText().toString();
                gender = edt_gender.getText().toString();
                if(id.equals("") || pw.equals("") || email.equals("") || name.equals("") || age.equals("") || gender.equals("")){
                    Toast.makeText(getApplicationContext(), "안돼 이사람아", Toast.LENGTH_SHORT).show();
                }else {
                    rq.add(srq);
                }
            }
        });

    }
}