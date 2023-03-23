package com.example.myapplication.mode;

import java.io.Serializable;

/**
 * 设备实体类
 */

public class EquipmentItem implements Serializable {
    /*
    *设备标题
     */
    private String title;
    /*
    设备描述
     */
    private String description;
    /**
     * 图片id
     */
    private  int imgId;
    /*
    生成方法Alt+insert，修改内容
     */
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }
}
