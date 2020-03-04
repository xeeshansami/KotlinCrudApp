package com.paxees.kotlinlearner;

import java.io.Serializable;

public class mForm implements Serializable {
    String id, name, number;
    private static mForm mInstance = null;

    public mForm() {
    }

    public static mForm getInstance() {
        if (mInstance == null) {
            mInstance = new mForm();
        }
        return mInstance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
