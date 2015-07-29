package com.example.gasper.myhome;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by gasper on 28.7.2015.
 */

public class RoomAdapter extends RecyclerView.Adapter<RoomAdapter.ContactViewHolder> {

    private List<Room> rooms;
    private MainActivity mainActivity;
    private Context context;




    public RoomAdapter(Context context, List<Room> contactList) {
        this.rooms = contactList;
        this.context = context;
    }


    @Override
    public int getItemCount() {
        return rooms.size();
    }

    @Override
    public void onBindViewHolder(ContactViewHolder contactViewHolder, int i) {
        Room room = rooms.get(i);
        contactViewHolder.vName.setText(room.getName());

        contactViewHolder.vTitle.setText(room.getLight().size() + " " + "devices");


    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.card_room, viewGroup, false);


        return new ContactViewHolder(itemView);
    }
    public void addRoom(Room room){
        this.rooms.add(room);
        notifyDataSetChanged();
    }

    public  class ContactViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        protected TextView vName;
        protected TextView vTitle;


        public ContactViewHolder(View v) {
            super(v);
            vName = (TextView) v.findViewById(R.id.txtName);
            vTitle = (TextView) v.findViewById(R.id.txtDevices);
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Room room = rooms.get(getPosition());
            Bundle bundle = new Bundle();
            bundle.putSerializable("room", room);

            Intent intent = new Intent(context, RoomActivity.class);
            intent.putExtras(bundle);
            intent.putExtra("position", getPosition());
            context.startActivity(intent);

        }
    }


}