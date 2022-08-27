package com.oshnisoft.retrofitapp;

import java.util.List;

public class OurMainDataClass {
    public OurMainDataClass() {
    }

    private List<ObjectData> data;

    public OurMainDataClass(List<ObjectData> data) {
        this.data = data;
    }

    public List<ObjectData> getData() {
        return data;
    }

    public void setData(List<ObjectData> data) {
        this.data = data;
    }
}
