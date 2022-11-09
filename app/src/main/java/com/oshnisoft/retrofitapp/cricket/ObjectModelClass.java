package com.oshnisoft.retrofitapp.cricket;

import android.icu.text.Transliterator;

public class ObjectModelClass {
    private String fullname;
    private String dateofbirth;
    private String gender;
    private PositionClass position;

    public ObjectModelClass() {
    }

    public ObjectModelClass(String fullname, String dateofbirth, String gender, PositionClass position) {
        this.fullname = fullname;
        this.dateofbirth = dateofbirth;
        this.gender = gender;
        this.position = position;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getDeteofbirth() {
        return dateofbirth;
    }

    public void setDeteofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public PositionClass getPosition() {
        return position;
    }

    public void setPosition(PositionClass position) {
        this.position = position;
    }
}
