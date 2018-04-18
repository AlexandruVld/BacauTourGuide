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

public class NatureFragment extends Fragment {

    ArrayList<Attraction> attractions = new ArrayList<>();

    public NatureFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list, container, false);

        attractions.add(new Attraction(getString(R.string.cancicov_park), getString(R.string.cancicov_park_description), R.drawable.cancicov));
        attractions.add(new Attraction(getString(R.string.roses_park), getString(R.string.roses_park_description), R.drawable.rosespark));
        attractions.add(new Attraction(getString(R.string.serbanesti_lake), getString(R.string.serbanesti_lake_description), R.drawable.serbanesti));
        attractions.add(new Attraction(getString(R.string.slanic_park), getString(R.string.slanic_park_description), R.drawable.slanicpark));
        attractions.add(new Attraction(getString(R.string.adventure_park_magura), getString(R.string.adventure_park_magura_description), R.drawable.magurapark));

        // Create the AttractionAdapter
        AttractionAdapter adapter = new AttractionAdapter(getActivity(), attractions);
        ListView listView = rootView.findViewById(R.id.list);
        listView.setBackgroundColor(getResources().getColor(R.color.nature_sights));
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

