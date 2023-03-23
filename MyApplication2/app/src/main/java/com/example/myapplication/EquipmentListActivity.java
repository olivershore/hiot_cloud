package com.example.myapplication;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.adapter.EquipmentAdapter;
import com.example.myapplication.mode.EquipmentItem;

import java.util.ArrayList;
import java.util.List;

public class EquipmentListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //绑定xml文件与activity文件
        setContentView(R.layout.activity_equipment_list);
        //recyclerView的初始化，
        RecyclerView rvEquipment = findViewById(R.id.rv_equipment_list);
        //设置hasFixedSize
        rvEquipment.setHasFixedSize(true);
        //设置布局管理器
        rvEquipment.setLayoutManager(new LinearLayoutManager(this));
        //设置适配器
        EquipmentAdapter equipmentAdapter =new EquipmentAdapter(this);
        equipmentAdapter.setOnItemClickListener(new EquipmentAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(EquipmentItem item) {
                Toast.makeText(EquipmentListActivity.this,item.getTitle() + item.getDescription(), Toast.LENGTH_SHORT).show();
                
            }
        });

        //初始化列表数据,创建一个空list赋值给List<内容对象>，设定默认描述，后续需创建EquipmentItem对象。
        List<EquipmentItem> list =new ArrayList<>();
        //预创建一个含有20个对象（equipmentItem）放入列表
        for (int i = 0; i < 20; i++) {
            EquipmentItem equipmentItem = new EquipmentItem();
            equipmentItem.setTitle("第"+ (i+1) + "个设备的标题");
            equipmentItem.setDescription("设备描述内容");
            equipmentItem.setImgId(R.drawable.equipment1);
            list.add(equipmentItem);
        }
        //设置适配器，创建新的适配器对象equipmentAdapter，使用setData方法里的（列表addAll）方法把列表导入对象

        equipmentAdapter.setData(list);
        rvEquipment.setAdapter(equipmentAdapter);
    }
}