package com.example.gasper.myhome;

import java.io.Serializable;

/**
 * Created by gasper on 28.7.2015.
 */
public class Light implements Serializable {
    public boolean isOn;
    private String uid;
    private String name;

    public Light(String name, String uid){
        this.name = name;
        this.uid = uid;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public String getUid(){
        return  this.uid;
    }
    public boolean getStatus(){
        return isOn;
    }


    public void turnOn(){
        isOn = true;
        new TurnOnTask().execute("set " + uid + " on");
    }
    public void turnOff(){
        isOn = false;
        new TurnOnTask().execute("set " + uid + " off");
    }
}
