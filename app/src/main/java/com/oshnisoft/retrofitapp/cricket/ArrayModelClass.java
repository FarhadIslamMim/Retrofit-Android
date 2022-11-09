package com.oshnisoft.retrofitapp.cricket;

import java.util.List;

public class ArrayModelClass {
    private List<ObjectModelClass> data;

    public ArrayModelClass() {
    }

    public ArrayModelClass(List<ObjectModelClass> data) {
        this.data = data;
    }

    public List<ObjectModelClass> getData() {
        return data;
    }

    public void setData(List<ObjectModelClass> data) {
        this.data = data;
    }
}
