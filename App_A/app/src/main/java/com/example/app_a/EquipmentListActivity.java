package com.example.app_a;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class EquipmentListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipment_list);

        //recyclerView 初始化
        RecyclerView rvEquipment =findViewById(R.id.rv_equipment_list);
        rvEquipment.setHasFixedSize(true);
        rvEquipment.setLayoutManager(new LinearLayoutManager(this));

        //设置初始化数据，设置适配器
        List<> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            srcList.add("第"+(i+1)+"行");


        }

    }
}