package com.nhw.jdbctest;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.annotation.TargetApi;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
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
import java.util.Locale;
import java.util.Map;

import static android.speech.tts.TextToSpeech.ERROR;

public class tale extends AppCompatActivity implements View.OnClickListener {

    ScrollView scv_subtitle;
    TextView tv_content;
    Button btn_sound, btn_back, btn_show, btn_slow, btn_fast;
    ImageView imv_bgm, img_back2;
    TextToSpeech tts;

    RequestQueue rq;
    StringRequest srq;

    String title;
    Intent intent;

    MediaPlayer mediaPlayer;
    boolean flag = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 화면을 landscape(가로) 화면으로 고정하고 싶은 경우
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_tale);

        mediaPlayer = MediaPlayer.create(this, R.raw.swreco);


        scv_subtitle = findViewById(R.id.scv_subtitle);
        tv_content = findViewById(R.id.tv_content);
        btn_sound = findViewById(R.id.btn_sound);
        btn_show = findViewById(R.id.btn_show);
        btn_slow = findViewById(R.id.btn_slow);
        btn_fast = findViewById(R.id.btn_fast);
        imv_bgm = findViewById(R.id.imv_bgm);
        img_back2 = findViewById(R.id.imv_back2);

        intent = getIntent();
        title = intent.getStringExtra("title");

        rq = Volley.newRequestQueue(this);

        String url = "http://61.80.106.120:8082/ProjectIL/GetTale";

        srq = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) { //  response에 값을 담아옴
                if (response.equals("")) {
                    Toast.makeText(getApplicationContext(), "안불러와져", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "불러오기 성공", Toast.LENGTH_SHORT).show();
                    tv_content.setText(response);  // 담아온 값으로 텍스트뷰를 바꿔줌
                    scv_subtitle.post(new Runnable() {
                        public void run() {
                            // TODO Auto-generated method stub
                            ObjectAnimator.ofInt(scv_subtitle, "scrollY", 4000).setDuration(85000).start();
                        }
                    });
                    Log.v("time", "log::" + response);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams(){
                HashMap<String, String> data = new HashMap<>();
                data.put("title", title);

                return data;
            }
        };
        srq.setTag("MAIN");

        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rq.add(srq);

            }
        });

        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    tts.setLanguage(Locale.ENGLISH);
                }
            }
        });


//            btn_sound.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    final String content = tv_content.getText().toString();
//                    tts.setPitch(1.0f);
//                    tts.setSpeechRate(1.0f);
//                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
//                        ttsGreater21(content);
//                    }else{
//                        ttsUnder20(content);
//                    }
//
//                }
//            });
//
//            btn_slow.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    final String content = tv_content.getText().toString();
//                    tts.setPitch(1.0f);
//                    tts.setSpeechRate(0.7f);
//                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
//                        ttsGreater21(content);
//                    }else{
//                        ttsUnder20(content);
//                    }
//                }
//            });
//
//            btn_fast.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    final String content = tv_content.getText().toString();
//                    tts.setPitch(1.0f);
//                    tts.setSpeechRate(1.3f);
//                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
//                        ttsGreater21(content);
//                    }else{
//                        ttsUnder20(content);
//                    }
//                }
//            });

//        img_bgm.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
        btn_sound.setOnClickListener(this);
        btn_slow.setOnClickListener(this);
        btn_fast.setOnClickListener(this);
        imv_bgm.setOnClickListener(this);
        img_back2.setOnClickListener(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (tts != null) {
            tts.stop();
            tts.shutdown();
            tts = null;
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
        String utteranceId = this.hashCode() + "";
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, utteranceId);
    }

    @Override
    public void onClick(View v) {
        final String content = tv_content.getText().toString();
        if (v.getId() == R.id.btn_sound) {
            tts.setPitch(1.0f);
            tts.setSpeechRate(0.75f);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                ttsGreater21(content);
            } else {
                ttsUnder20(content);
            }
        } else if (v.getId() == R.id.btn_slow) {
            tts.setPitch(1.0f);
            tts.setSpeechRate(0.6f);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                ttsGreater21(content);
            } else {
                ttsUnder20(content);
            }
        } else if (v.getId() == R.id.btn_fast) {
            tts.setPitch(1.0f);
            tts.setSpeechRate(1.0f);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                ttsGreater21(content);
            } else {
                ttsUnder20(content);
            }
        } else if(v.getId() == R.id.imv_bgm){
            mediaPlayer.start();
            mediaPlayer.setVolume(0.7f, 0.7f);
            if (flag) {
                mediaPlayer.pause();
                flag = false;
                imv_bgm.setImageResource(R.drawable.bgmon);
            } else {
                mediaPlayer.start();
                flag = true;
                imv_bgm.setImageResource(R.drawable.bgmoff);
            }
        } else if(v.getId() == R.id.imv_back2){
            finish();
        }
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            ttsGreater21(content);
//        } else {
//            ttsUnder20(content);
//        }
    }
}