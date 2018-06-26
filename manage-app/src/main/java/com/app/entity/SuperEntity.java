package com.app.entity;

import com.baomidou.mybatisplus.activerecord.Model;

import java.io.Serializable;

/**
 * 创建人: Hjx
 * Date: 2018/6/13
 * Description:
 */
public class SuperEntity<T extends Model> extends Model<T>{

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }
}
