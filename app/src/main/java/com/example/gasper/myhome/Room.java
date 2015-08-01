package com.example.gasper.myhome;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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

    public  String toJson(){
        try{
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("roomName", this.roomName);

            JSONArray json = new JSONArray();
            for(Light light : lights){
                JSONObject tmp = new JSONObject();
                tmp.put("status", light.getStatus());
                tmp.put("name", light.getName());
                tmp.put("ui", light.getUid());
                json.put(tmp);
            }
            jsonObject.put("lights", json);

            return jsonObject.toString();


        }
        catch (JSONException e){
            e.printStackTrace();
        }
        return null;
    }

}
