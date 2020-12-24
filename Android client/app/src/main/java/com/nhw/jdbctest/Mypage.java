package com.nhw.jdbctest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.pedro.library.AutoPermissions;
import com.pedro.library.AutoPermissionsListener;

import org.json.JSONObject;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.OkHttpClient;

public class Mypage extends AppCompatActivity implements AutoPermissionsListener {

    ImageView btn_learn, btn_game, btn_update, btn_read, imv_back;
    TextView tv_welcome;
    File file;
    Intent intent;
    String id, name;

    byte[] byteArray;

    RequestQueue rq;
    StringRequest srq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);
        intent = getIntent();
        id = intent.getStringExtra("id");
        name = intent.getStringExtra("name");

        btn_update = findViewById(R.id.btn_update);
        btn_learn = findViewById(R.id.btn_photo);
        btn_game = findViewById(R.id.btn_game);
        btn_read = findViewById(R.id.btn_read);
        tv_welcome = findViewById(R.id.tv_welcome);
        imv_back = findViewById(R.id.imv_back);

        tv_welcome.setText(id+"님 환영합니다!");

        btn_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Mypage.this, Game.class);
                startActivity(intent);
            }
        });
        btn_read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Mypage.this, Fairytale.class);
                startActivity(intent);

            }
        });
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Mypage.this, Update.class);
                intent.putExtra("id", id);
                intent.putExtra("name", name);
                startActivity(intent);
            }
        });
        btn_learn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takePicture();
            }
        });
        AutoPermissions.Companion.loadAllPermissions(this, 101);

        imv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void takePicture() {
        if (file == null) {
            file = createFile(); // 사진을 저장할 빈 파일 생성
        }

        // file 객체로부터 uri 객체 생성
        Uri fileUri = FileProvider.getUriForFile(this, "org.techtown.capture.intent.fileprovider", file);
        // Uri 객체란??

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
        if (intent.resolveActivity(getPackageManager()) != null) {
            // 카메라 실행
            startActivityForResult(intent, 101);
        }


    }

    private File createFile() {
        String filename = "capture.jpg";
        File storageDir = Environment.getExternalStorageDirectory();
        File outFile = new File(storageDir, filename);

        return outFile;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.v("data","onActivityResult");
        if (requestCode == 101 && resultCode == RESULT_OK) {
            Log.v("data", "onActivityResult if?");

            // 이미지 파일을 bitmap 객체로 만들기
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 8;
            Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath(), options);

            // byte[]로 만드는 bytearraystream 객체
            ByteArrayOutputStream stream = new ByteArrayOutputStream();

            // intent는 100kbyte이상 안넘어가서 압축해주는 작업
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);

            // stream 데이터를 bitmap으로
            byteArray = stream.toByteArray();

            final String imageBase64 = Base64.encodeToString(byteArray, 0);


            // 카메라 activity로 꺼져
            intent = new Intent(getApplicationContext(), Camera.class);
            intent.putExtra("capture", byteArray); // 그럼 바꾸고 다시해보자 근데 에러는 안나는데




            // 파이썬 url
            String ROOT_URL = "http://61.80.106.120:5000/and";

            rq=Volley.newRequestQueue(getApplicationContext());

            srq=new StringRequest(Request.Method.POST, ROOT_URL, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.v("response","서버로부터::"+response);
                    intent.putExtra("caption",response);
                    startActivity(intent);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("response","서버로부터 에러::"+error);
                }
            }){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    HashMap<String, String> data=new HashMap<>();
                    data.put("img",imageBase64);
                    return data;
                }

            };
            srq.setTag("MAIN");
            rq.add(srq);
            startActivity(intent);
        }
    }


    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        AutoPermissions.Companion.parsePermissions(this, requestCode, permissions, this);
    }


    @Override
    public void onDenied(int i, String[] strings) {
//        Toast.makeText(this, "", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onGranted(int i, String[] strings) {
//        Toast.makeText(this, "permissions granted", Toast.LENGTH_LONG).show();
    }



}
