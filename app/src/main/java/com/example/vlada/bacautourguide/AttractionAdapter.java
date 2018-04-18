package com.example.vlada.bacautourguide;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AttractionAdapter extends ArrayAdapter<Attraction>{

    public AttractionAdapter(Activity context, ArrayList<Attraction> attractions) {
        // Initialize the ArrayAdapter's internal storage for the context
        super(context, 0, attractions);
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listView = convertView;
        if (listView == null) {
            listView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Attraction currentAttraction = getItem(position);

        TextView title = listView.findViewById(R.id.sight_title);

        title.setText(currentAttraction.getTitle());

        TextView description = listView.findViewById(R.id.sight_description);

        description.setText(currentAttraction.getDescription());

        ImageView imageView = listView.findViewById(R.id.image);

        imageView.setImageResource(currentAttraction.getImageResourceId());

        imageView.setVisibility(View.VISIBLE);

        imageView.setScaleType(ImageView.ScaleType.FIT_XY);

        return listView;
    }
}
