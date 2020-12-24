package com.nhw.jdbctest;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Game extends AppCompatActivity {

    Button btn_try, btn_ans, btn_next, btn_pre;
    ImageButton imbtn_back;
    ImageView imv_pic;
    TextView tv_caption;
    EditText edt_first, edt_second;
    int arr[] = new int[30];
    String str[] = new String[30];
    String[] caption;
    int num = 0;
    String text;
    int a, b;
    String ans1, ans2;
    int cnt = 0;


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        final Random ran = new Random();

        btn_try = findViewById(R.id.btn_try);
        btn_ans = findViewById(R.id.btn_ans);
        btn_next = findViewById(R.id.btn_next);
        btn_pre = findViewById(R.id.btn_pre);
        imv_pic = findViewById(R.id.imv_pic);
        tv_caption = findViewById(R.id.tv_caption);
        edt_first = findViewById(R.id.edt_first);
        edt_second = findViewById(R.id.edt_second);
        imbtn_back = findViewById(R.id.imbtn_back);

        arr[0] = R.drawable.pic1;
        arr[1] = R.drawable.pic2;
        arr[2] = R.drawable.pic3;
        arr[3] = R.drawable.pic4;
        arr[4] = R.drawable.pic5;
        arr[5] = R.drawable.pic6;
        arr[6] = R.drawable.pic7;
        arr[7] = R.drawable.pic8;
        arr[8] = R.drawable.pic9;
        arr[9] = R.drawable.pic10;
        arr[10] = R.drawable.pic11;
        arr[11] = R.drawable.pic12;
        arr[12] = R.drawable.pic13;
        arr[13] = R.drawable.pic14;
        arr[14] = R.drawable.pic15;
        arr[15] = R.drawable.pic16;
        arr[16] = R.drawable.pic17;
        arr[17] = R.drawable.pic18;
        arr[18] = R.drawable.pic19;
        arr[19] = R.drawable.pic20;
        arr[20] = R.drawable.pic21;
        arr[21] = R.drawable.pic22;
        arr[22] = R.drawable.pic23;
        arr[23] = R.drawable.pic24;
        arr[24] = R.drawable.pic25;
        arr[25] = R.drawable.pic26;
        arr[26] = R.drawable.pic27;
        arr[27] = R.drawable.pic28;
        arr[28] = R.drawable.pic29;
        arr[29] = R.drawable.pic30;

        str[0] = "Two horses are running through a field";
        str[1] = "People are eating food at kitchen and a young boy is sitting on the chair";
        str[2] = "A group of children and adults are gathered around the table";
        str[3] = "A sandwich and fries are shaped as a heart";
        str[4] = "Groceries are displayed with fruits vegetables caned and packaged goods";
        str[5] = "A cat is sleeping on an outdoor bench";
        str[6] = "A big truck is parked on a camping ground";
        str[7] = "The police officer is waving hand on a motorcycle";
        str[8] = "Two giraffes are looking around by the tree";
        str[9] = "There are brown cake and strawberries on the plate";
        str[10] = "A group of giraffes are standing next to the rhinos";
        str[11] = "A bunch of food is piled on top of the table";
        str[12] = "A large bird is waddling on the beach";
        str[13] = "A dark colored airplane sitting on a runway";
        str[14] = "An artistic vase with a yellow flower and two roses is placed on table";
        str[15] = "A wooden bench is placed next to a green fence in the amusement park";
        str[16] = "A spotted cat is rolling around by the laptop";
        str[17] = "A man playing tennis on a court with a tennis racket";
        str[18] = "A woman with child and dog sit on the grass in front of a bench";
        str[19] = "A man is riding a skateboard down a rural road";
        str[20] = "A dog wrapped in a blanket while sleeping on a bed";
        str[21] = "A yellow school bus is traveling down a road filled with traffic";
        str[22] = "Two teams of girls are playing soccer";
        str[23] = "Four giraffes are resting next to a tree";
        str[24] = "A little boy is sitting on a wooden rocking chair";
        str[25] = "A woman is riding a surfboard in a skimpy outfit";
        str[26] = "A white table topped with small white plates filled with chocolate and baking ingredients ";
        str[27] = "A river filled with lots of boats next to tall buildings ";
        str[28] = "Baseball batter waiting for ball while umpire holds in glove  out";
        str[29] = "A train is standing at the station under tree";


        num = ran.nextInt(str.length);
        // 문장을 스플릿해서 캡션이라는 배열에 담기
        // 맨처음 나오는 사진, 문장
        caption = str[num].split(" ");
        nextgame(ran, caption);
        imv_pic.setImageResource(arr[num]);
        tv_caption.setText(text);

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (num < 29) {
                    num++;
                    Log.v("now", "num++" + num);
                } else if (num == 29) {
                    Log.v("now", "num=0");
                    num = 0;
                }
                final String[] caption = str[num].split(" ");
                nextgame(ran, caption);
                imv_pic.setImageResource(arr[num]);
                tv_caption.setText(text);
                edt_first.setText("");
                edt_second.setText("");

                cnt=0;
            }
        });

        btn_pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(num > 0){
                    num--;
                    final String[] caption = str[num].split(" ");
                    nextgame(ran, caption);
                    imv_pic.setImageResource(arr[num]);
                    tv_caption.setText(text);
                    edt_first.setText("");
                    edt_second.setText("");
                }else if(num == 0){
                    Toast.makeText(getApplicationContext(), "첫번째 문장입니다!", Toast.LENGTH_SHORT).show();
                }
                cnt =0;
            }
        });

        btn_try.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("ans", ans1);
                Log.v("ans", ans2);
                if (ans1.equals(edt_first.getText().toString()) && ans2.equals(edt_second.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "정답입니다!", Toast.LENGTH_SHORT).show();
                } else if (ans1.equals(edt_first.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "두번째 빈칸 다시 생각해봐요!", Toast.LENGTH_SHORT).show();
                } else if (ans2.equals(edt_second.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "첫번째 빈칸 다시 생각해보세요!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "틀렸어요!", Toast.LENGTH_SHORT).show();
                }
                cnt++;
            }
        });
        btn_ans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cnt >= 3) {
                    tv_caption.setText(str[num]);
                }else{
                    Toast.makeText(getApplicationContext(), "3번 이상 입력해야 정답을 확인할 수 있습니다!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        imbtn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    // 단어별로 분할해서 담은 caption 배열에 랜덤으로 2개의 빈칸을 만들고, '___'로 바꾸고, 다시 한 문장으로 만드는 메소드
    @RequiresApi(api = Build.VERSION_CODES.O)
    void nextgame(Random ran, String[] caption) {
        while (true) {
            a = ran.nextInt(caption.length);
            b = ran.nextInt(caption.length);
            ans1 = caption[a];
            ans2 = caption[b];
            if (a != b && a < b) {
                caption[a] = "___";
                caption[b] = "___";
                text = String.join(" ", caption);
                break;
            }
        }
    }
}