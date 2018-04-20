package com.example.vlada.bacautourguide;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class CultureFragment extends Fragment {

    ArrayList<Attraction> attractions = new ArrayList<>();

    public CultureFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list, container, false);

        attractions.add(new Attraction(getString(R.string.bacovia_house), getString(R.string.bacovia_house_description), R.drawable.bacovia));
        attractions.add(new Attraction(getString(R.string.stirbei_castle), getString(R.string.stirbei_castle_description), R.drawable.stirbeicastle));
        attractions.add(new Attraction(getString(R.string.enescu_house), getString(R.string.enescu_house_description), R.drawable.enescu));
        attractions.add(new Attraction(getString(R.string.precista_church), getString(R.string.precista_church_description), R.drawable.precista));
        attractions.add(new Attraction(getString(R.string.iulian_antonescu_museum), getString(R.string.iulian_antonescu_description), R.drawable.iulianantonescu));

        // Create the AttractionAdapter
        AttractionAdapter adapter = new AttractionAdapter(getActivity(), attractions);
        ListView listView = rootView.findViewById(R.id.list);
        listView.setBackgroundColor(getResources().getColor(R.color.cultural_sights));
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
