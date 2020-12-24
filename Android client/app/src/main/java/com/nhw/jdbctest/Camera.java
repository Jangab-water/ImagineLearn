package com.nhw.jdbctest;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Locale;


public class Camera extends AppCompatActivity {

    Button btn_speed_low, btn_speed_fast, btn_caption, btn_speak;
    ImageView imgView, imv_back;
    TextView tv_caption, tv_speed;
    TextToSpeech tts;
    RequestQueue rq;
    StringRequest srq;
    int cnt=0;
    Intent intent;

    String caption = "A man is drinking coffee by the table.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        btn_caption = findViewById(R.id.btn_caption);
        btn_speak = findViewById(R.id.btn_speak);
        btn_speed_low = findViewById(R.id.btn_speed_low);
        btn_speed_fast = findViewById(R.id.btn_speed_fast);
        imv_back = findViewById(R.id.imv_back3);

        imgView = findViewById(R.id.imgView);

        tv_caption = findViewById(R.id.tv_caption);
        tv_speed = findViewById(R.id.tv_speed);

        intent = getIntent();
//        String caption=intent.getStringExtra("caption");


        imv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        byte[] byteArray = getIntent().getByteArrayExtra("capture");
        Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        imgView.setImageBitmap(bitmap); // base64 인코딩

        btn_speed_fast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tv_speed.getText().equals("x1")){
                    tv_speed.setText("x1.3");
                }else if(tv_speed.getText().equals("x0.7")){
                    tv_speed.setText("x1");
                }else {
                    Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_LONG).show();
                }
            }
        });

        btn_speed_low.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tv_speed.getText().equals("x1")){
                    tv_speed.setText("x0.7");
                }else if(tv_speed.getText().equals("x1.3")){
                    tv_speed.setText("x1");
                }else {
                    Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_LONG).show();
                }
            }
        });

        tts=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    tts.setLanguage(Locale.ENGLISH);
                }
            }


        });

        btn_speak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = tv_caption.getText().toString();
                if(tv_speed.getText().equals("x0.7")){
                    tts.setSpeechRate(0.7f);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        ttsGreater21(text);
                    } else {
                        ttsUnder20(text);
                    }
                }else if(tv_speed.getText().equals("x1")){
                    tts.setSpeechRate(1.0f);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        ttsGreater21(text);
                    } else {
                        ttsUnder20(text);
                    }
                }else if(tv_speed.getText().equals("x1.3")){
                    tts.setSpeechRate(1.3f);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        ttsGreater21(text);
                    } else {
                        ttsUnder20(text);
                    }
                }

            }
        });

        btn_caption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_caption.setText(caption);
                if(cnt%2==0){
                    btn_caption.setText("영어문장 숨기기");
                    tv_caption.setVisibility(View.VISIBLE);
                    cnt++;
                }else if(cnt%2==1){
                    btn_caption.setText("영어문장 보기");
                    tv_caption.setVisibility(View.INVISIBLE);
                    cnt++;
                }
            }
        });

    }

    protected void onDestroy() {
        super.onDestroy();

        if(tts !=null){
            tts.stop();
            tts.shutdown();
        }
    }


    @SuppressWarnings("deprecation")
    private void ttsUnder20(String text) {
        HashMap<String, String> map = new HashMap<>();
        map.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, "MessageId");
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, map);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void ttsGreater21(String text) {
        String utteranceId=this.hashCode() + "";
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, utteranceId);
    }
}