package com.example.gasper.myhome;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.content.Intent;

import java.util.ArrayList;

public class MainActivity extends ActionBarActivity {
    private RoomAdapter ra;
    public ArrayList<Room> rooms;
    public static MainActivity self;
    private Bundle bundle;
    private int check = 0;

    public MainActivity(){
        MainActivity.self = this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();


        RecyclerView recView = (RecyclerView) findViewById(R.id.list);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recView.setLayoutManager(llm);
        if(intent.getBooleanExtra("key", false)){
            rooms = RoomActivity.self.rooms;
        }
        else {
            rooms = createList();

        }
        ra = new RoomAdapter(this, rooms);
        recView.setAdapter(ra);





        ImageButton addButton = (ImageButton) findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
                LinearLayout lin = (LinearLayout) inflater.inflate(R.layout.dialog_add_room, null);
                dialog.setView(lin);
                dialog.setTitle("Create new room");
                final EditText edit = (EditText) lin.findViewById(R.id.editText);

                dialog.setPositiveButton("Add Room", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String roomName = edit.getText().toString();
                        Room new_room = new Room(roomName, new ArrayList<Light>());
                        ra.addRoom(new_room);


                    }
                });
                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog alertDialog = dialog.create();
                alertDialog.show();


            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }
    public void setList(ArrayList<Room> tmp){
        Log.e("tag","nej bi delal");
        this.rooms = tmp;
        this.check = 1;

    }

    private ArrayList<Room> createList(){


        ArrayList<Light> lights = new ArrayList<Light>();
        Light light = new Light("luč1", "HUEDevice3");
        lights.add(light);
        

        this.rooms = new ArrayList<Room>();
        Room room = new Room("klet", lights);

        rooms.add(room);
        /*for(int i=1; i<= 10; i++){
            Room room = new Room(("Room " + Integer.toString(i)), lights);
            this.rooms.add(room);
        }*/

        return this.rooms;

    }
}
