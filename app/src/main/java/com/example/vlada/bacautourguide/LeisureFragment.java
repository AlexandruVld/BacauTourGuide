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

public class LeisureFragment extends Fragment{

    ArrayList<Attraction> attractions = new ArrayList<>();

    public LeisureFragment (){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list, container, false);

        attractions.add(new Attraction(getString(R.string.valhalla), getString(R.string.valhalla_description), R.drawable.valhalla));
        attractions.add(new Attraction(getString(R.string.noblesse), getString(R.string.noblesse_description), R.drawable.noblesse));
        attractions.add(new Attraction(getString(R.string.latin), getString(R.string.latin_description), R.drawable.latin));
        attractions.add(new Attraction(getString(R.string.mauro), getString(R.string.mauro_description), R.drawable.mauro));
        attractions.add(new Attraction(getString(R.string.president), getString(R.string.president_description), R.drawable.presidentres));

        // Create the AttractionAdapter
        AttractionAdapter adapter = new AttractionAdapter(getActivity(), attractions);
        ListView listView = rootView.findViewById(R.id.list);
        listView.setBackgroundColor(getResources().getColor(R.color.leisure));
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
