package com.share4happy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    Button btn1,btn2,btn3;
    Animation animation = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvent();
    }

    private void addEvent() {
        // sự kiện nút 1: xoay controls
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animation = AnimationUtils.loadAnimation(MainActivity.this,R.anim.xoaycontrol);
                btn1.startAnimation(animation);
            }
        });
        // sự kiện nút 2: xoay màn hình
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animation = AnimationUtils.loadAnimation(MainActivity.this,R.anim.xoaymanhinh);
                LinearLayout manhinh = findViewById(R.id.manhinh_Linearlayout);
                manhinh.startAnimation(animation);
            }
        });
        // Sự kiện nút 3: xoay sau 3 giây và thoát trương chình
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animation = AnimationUtils.loadAnimation(MainActivity.this,R.anim.xoaycontrol);
                btn3.startAnimation(animation);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    //Khi bắt đầu
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }
                    // khi kết thúc
                    @Override
                    public void onAnimationEnd(Animation animation) {
                        finish(); // kết thúc trương trình
                    }
                    // lặp lại
                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });
    }

    private void addControls() {
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
    }
}