package com.example.gasper.myhome;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import java.util.List;

/**
 * Created by gasper on 28.7.2015.
 */
public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<Light> lights;
    private MainActivity mainActivity;
    private Context context;




    public Adapter(Context context, List<Light> lights) {
        this.lights = lights;
        this.context = context;
    }


    @Override
    public int getItemCount() {
        return lights.size();
    }

    @Override
    public void onBindViewHolder(ViewHolder contactViewHolder, int i) {
        Light light = lights.get(i);
        contactViewHolder.vName.setText(light.getName());




    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.card_light, viewGroup, false);


        return new ViewHolder(itemView);
    }
    public void addLight(Light light){
        this.lights.add(light);
        notifyItemInserted(this.lights.size()-1);
    }

    public  class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        protected TextView vName;
        protected Switch status;


        public ViewHolder(View v) {
            super(v);
            vName = (TextView) v.findViewById(R.id.name);
            status = (Switch) v.findViewById(R.id.switch1);

        }

        @Override
        public void onClick(View v) {



        }
    }


}