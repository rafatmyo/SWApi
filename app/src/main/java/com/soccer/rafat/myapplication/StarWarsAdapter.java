package com.soccer.rafat.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by rafat on 13/02/2018.
 */

public class StarWarsAdapter extends ArrayAdapter<Match> {
    private Context context;
    public StarWarsAdapter(@NonNull Context context, int resource, @NonNull List<Match> objects) {
        super(context, resource, objects);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.starwars_characters,parent,false);
        }
        Match match = getItem(position);
        TextView name = (TextView) convertView.findViewById(R.id.name);
        TextView birth = (TextView) convertView.findViewById(R.id.birth);
        name.setText(match.name);
        birth.setText(match.birth);
        convertView.setBackgroundResource(R.color.colorPrimary);
        return convertView;
    }
}








