package com.myapplicationdev.android.p05_ndpsongs;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.myapplicationdev.android.p05_ndpsongs.Song;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<Song> songlist;

    public CustomAdapter(Context context, int id, ArrayList<Song> list) {
        super(context,id,list);
        parent_context=context;
        layout_id=id;
        songlist=list;

    }
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtain the LayoutInflater object
        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // "Inflate" the View for each row
        View rowView = inflater.inflate(layout_id, parent, false);

        // Obtain the UI components and do the necessary binding
        TextView songname = rowView.findViewById(R.id.songname);
        TextView tvstars = rowView.findViewById(R.id.tvstars);
        TextView tvsinger = rowView.findViewById(R.id.tvsinger);
        TextView tvyear = rowView.findViewById(R.id.tvyear);

        // Obtain the Android Version information based on the position
        Song currentVersion = songlist.get(position);

        // Set values to the TextView to display the corresponding information

        songname.setText(currentVersion.getTitle());
        tvyear.setText((String.valueOf(currentVersion.getYearReleased())));
        tvsinger.setText(currentVersion.getSingers());
        tvstars.setText(currentVersion.toString());

        return rowView;
    }
}

