package com.example.vlada.bacautourguide;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class AccommodationFragment extends Fragment {

    ArrayList<Attraction> attractions = new ArrayList<>();

    public AccommodationFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list, container, false);

        attractions.add(new Attraction(getString(R.string.hotel_decebal), getString(R.string.hotel_decebal_description), R.drawable.decebal));
        attractions.add(new Attraction(getString(R.string.hotel_moldova), getString(R.string.hotel_moldova_description), R.drawable.moldova));
        attractions.add(new Attraction(getString(R.string.hotel_dumbrava), getString(R.string.hotel_dumbrava_description), R.drawable.dumbrava));
        attractions.add(new Attraction(getString(R.string.hotel_president), getString(R.string.hotel_president_description), R.drawable.president));
        attractions.add(new Attraction(getString(R.string.hotel_helen), getString(R.string.hotel_president_description), R.drawable.helen));

        // Create the AttractionAdapter
        AttractionAdapter adapter = new AttractionAdapter(getActivity(), attractions);
        ListView listView = rootView.findViewById(R.id.list);
        listView.setBackgroundColor(getResources().getColor(R.color.accommodation));
        listView.setAdapter(adapter);

        // Opens the descriptions when the list item is clicked
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String title = attractions.get(position).getTitle();
                String description = attractions.get(position).getDescription();
                int image = attractions.get(position).getImageResourceId();
                Intent detailsIntent = new Intent(getActivity(), Data.class);
                detailsIntent.putExtra("description", description);
                detailsIntent.putExtra("title", title);
                detailsIntent.putExtra("image", image);
                startActivity(detailsIntent);
            }
        });

        return rootView;
    }
}
