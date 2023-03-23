package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myapplication.adapter.EquipmentAdapter;
import com.example.myapplication.mode.EquipmentBean;

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
        rvEquipment.setHasFixedSize(true);
        rvEquipment.setLayoutManager(new LinearLayoutManager(this));
        //初始化列表数据,创建一个空list赋值给List<内容对象>，设定默认描述，后续需创建EquipmentBean对象。
        List<EquipmentBean> list =new ArrayList<>();
        //预创建一个含有20个对象（equipmentBean）放入列表
        for (int i = 0; i < 20; i++) {
            EquipmentBean equipmentBean = new EquipmentBean();
            equipmentBean.setTitle("第"+ (i+1) + "个设备的标题");
            equipmentBean.setDescription("设备描述内容");
            equipmentBean.setImgId(R.drawable.equipment1);
            list.add(equipmentBean);
        }
        //设置适配器，创建新的适配器对象equipmentAdapter，使用setData方法里的（列表addAll）方法把列表导入对象
        EquipmentAdapter equipmentAdapter =new EquipmentAdapter(this);
        equipmentAdapter.setData(list);
        rvEquipment.setAdapter(equipmentAdapter);
    }
}