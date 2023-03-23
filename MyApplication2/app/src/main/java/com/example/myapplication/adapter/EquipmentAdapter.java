package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.mode.EquipmentItem;

import java.util.ArrayList;
import java.util.List;

/**
 * 设备适配器：功能onCreateViewHolder
 */

public class EquipmentAdapter extends RecyclerView.Adapter<EquipmentAdapter.ViewHolder> {
    private Context context;
    //equipmentItemList 初始化
    private List<EquipmentItem> equipmentItemList = new ArrayList<>();

    private OnItemClickListener onItemClickListener;

    /**
     *点击接口变量
     */


    //context内容传进来保留到全局变量context，context即viewGroup。
    public EquipmentAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public EquipmentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //创建itemView，XML通过inflate方法创建视项 itemView，再利用视项 itemView 创建View holder
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.adapter_item_equipment, parent, false);
        //创建viewHolder
        return new EquipmentAdapter.ViewHolder(itemView);

    }

    //通过onBindViewHolder方法绑定ViewHolder与position，其中调用bindData方法，实现修改视项的功能

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindData(position);
        final EquipmentItem equipmentItem = equipmentItemList.get(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(equipmentItem);

            }
        });

    }

    //获取列表数量方法
    @Override
    public int getItemCount() {
        return equipmentItemList.size();
    }

    /**
     * 设置列表，通过setData实现修改视项内容的功能
     *
     * @param
     */

    public void setData(List<EquipmentItem> list) {
        equipmentItemList.addAll(list);
    }

    //定义一个内部接口，用作点击事件
    public interface OnItemClickListener{
        void onItemClick(EquipmentItem item);
    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;

    }
    /**
     * 点击接口事件
     */

    public class ViewHolder extends RecyclerView.ViewHolder {
        //变量设置为全局变量，方便子方法调用
        private TextView tvTitle;
        private TextView tvDsc;
        private ImageView ivImage;

        /**
         * 取出可能对象各部分
         *
         * @param
         */
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //在需要改变对象时，通过id可以定位到对象
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvDsc = itemView.findViewById(R.id.tv_dsc);
            ivImage = itemView.findViewById(R.id.iv_image);
        }
        //bind data方法

        /**
         * 修改列表项内容
         *
         * @param
         */
        public void bindData(int position) {
            EquipmentItem item = equipmentItemList.get(position);
            tvTitle.setText(item.getTitle());
            tvDsc.setText(item.getDescription());
            ivImage.setImageResource(item.getImgId());
        }
    }
}