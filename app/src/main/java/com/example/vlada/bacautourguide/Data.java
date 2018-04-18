package com.example.vlada.bacautourguide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class Data extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_layout);

        // Get attraction title
        String attractionTitle = getIntent().getStringExtra("title");
        TextView actualTitle = findViewById(R.id.content_title);

        // Set the attraction title
        actualTitle.setText(attractionTitle);

        // Get attraction description
        String attractionDescription = getIntent().getStringExtra("description");
        TextView contentDescription = findViewById(R.id.content_description);

        // Set the attraction description
        contentDescription.setText(attractionDescription);

        // Get image resource id
        int attractionImage = getIntent().getIntExtra("image", 0);
        ImageView actualImage = findViewById(R.id.content_image);

        // Set the image
        actualImage.setImageResource(attractionImage);

        // Stretch image in imageView to fit screen
        actualImage.setScaleType(ImageView.ScaleType.FIT_XY);

    }
}
