package com.example.app_a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btBasicList = findViewById(R.id.bt_basic_list);
        btBasicList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,BasicListActivity.class);
                startActivity(intent);
            }
        });
        //设置设备列表点击事件
        Button btEquipmentList = findViewById(R.id.bt_equipment_list);
        btEquipmentList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this, EquipmentListActivity.class);
                startActivity(intent);
            }
        });
    }
}