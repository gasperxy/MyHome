package com.example.gasper.myhome;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
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

import java.util.ArrayList;

public class RoomActivity extends ActionBarActivity {
    private Bundle bundle;
    private Room room;
    private int position;
    public ArrayList<Room> rooms;
    public static RoomActivity self;

    public RoomActivity(){
        RoomActivity.self = this;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        this.bundle = getIntent().getExtras();
        room = (Room) this.bundle.getSerializable("room");
        position = bundle.getInt("position");
        rooms = MainActivity.self.rooms;

        Log.e("position", Integer.toString(position));


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(room.getName());
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list1);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);
        final Adapter adapter = new Adapter(this, room.getLight());
        recyclerView.setAdapter(adapter);

        ImageButton button = (ImageButton) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(RoomActivity.this);
                LayoutInflater inflater = LayoutInflater.from(RoomActivity.this);
                LinearLayout lin = (LinearLayout) inflater.inflate(R.layout.dialog_add_light, null);
                dialog.setView(lin);
                dialog.setTitle("Add new light");
                final EditText edit = (EditText) lin.findViewById(R.id.editText2);
                final EditText edit1 = (EditText) lin.findViewById(R.id.editText3);

                dialog.setPositiveButton("Add light", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String lightName = edit.getText().toString();
                        String lightUid = edit1.getText().toString();
                        Light new_light = new Light(lightName, lightUid);
                        room.addLight(new_light);




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
        getMenuInflater().inflate(R.menu.menu_room, menu);
        return true;
    }
    @Override
    public void onBackPressed(){


        rooms.set(position, room);
        Intent intent = new Intent(RoomActivity.this, MainActivity.class);
        intent.putExtra("key", true);

        startActivity(intent);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if(id == android.R.id.home){
            Log.e("tag", "notr");

            rooms.set(position, room);
            Intent intent = new Intent(RoomActivity.this, MainActivity.class);
            intent.putExtra("key", true);

            startActivity(intent);
            return true;


        }

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }
}
