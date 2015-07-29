package com.example.gasper.myhome;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by gasper on 28.7.2015.
 */
public class Room implements Serializable {
    private String roomName;
    private ArrayList<Light> lights;

    public Room(String name, ArrayList<Light> lights){
        this.roomName = name;
        this.lights = lights;
    }

    public void addLight(Light light){
        this.lights.add(light);
    }

    public String getName(){
        return roomName;
    }
    public ArrayList<Light> getLight(){
        return lights;
    }
    public void setName(String name){
        this.roomName = name;
    }
}
