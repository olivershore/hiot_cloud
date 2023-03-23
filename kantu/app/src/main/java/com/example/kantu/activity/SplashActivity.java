package com.example.kantu.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.example.kantu.R;

import java.util.Timer;
import java.util.TimerTask;

@SuppressLint("HandlerLeak")
public class SplashActivity extends AppCompatActivity {

    private static final int HANDLER_MSG_OPEN_NEW =1 ;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            boolean hasLogin = true;
            if (msg.what == HANDLER_MSG_OPEN_NEW){
                //ToDo 根据登录状态给hasLogin赋值

                //打开列表界面或登录界面
                if (hasLogin){
                    //打开列表界面
                    Intent intent =new Intent(SplashActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    //打开登录界面


                }

            }
        }
    };
    private long delay=3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //设置定时器
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(HANDLER_MSG_OPEN_NEW);

            }
        },delay);

    }
}