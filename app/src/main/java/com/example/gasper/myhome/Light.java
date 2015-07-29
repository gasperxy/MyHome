package com.example.gasper.myhome;

import java.io.Serializable;

/**
 * Created by gasper on 28.7.2015.
 */
public class Light implements Serializable {
    private boolean isOn;
    private int id;
    private String name;

    public Light(String name, int id){
        this.name = name;
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }


    public void turnOn(){
        isOn = true;
    }
    public void turnOff(){
        isOn = false;
    }
}
