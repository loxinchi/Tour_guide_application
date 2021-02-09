package com.example.android.tour_guide_annecy;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class GuideDetailsActivity extends AppCompatActivity {

    TextView tName, tAddress, tPhone;
    ImageView coverPhoto, mapIcon, webIcon, callIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_detail);
        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }

        //Allocate each TextView and ImageView
        tName = findViewById(R.id.item_name);
        tAddress = findViewById(R.id.item_address);
        tPhone = findViewById(R.id.item_tel);
        coverPhoto = findViewById(R.id.item_image);

        //Get intent
        Intent intent = getIntent();
        Bundle bundle = this.getIntent().getExtras();

        int pic = bundle.getInt("coverPhoto");
        int aName = intent.getIntExtra("name", 0);
        int aTel = intent.getIntExtra("tel", 0);
        int aAddress = intent.getIntExtra("address", 0);
        int aWebsiteUrl = intent.getIntExtra("websiteUrl", 0);

        //Set Text and Image from received intent
        tName.setText(aName);
        tAddress.setText(aAddress);
        coverPhoto.setImageResource(pic);
        tPhone.setText(aTel);

        //Convert intent data to String for another intent use
        String addressString = getString(aAddress);
        String telString = getString(aTel);
        String urlString = getString(aWebsiteUrl);
        System.out.println("!~~~~~~~~~~~~~~~DEBUG~~~~~~~~~~~~~~!:addressString"+ addressString);
        System.out.println("!~~~~~~~~~~~~~~~DEBUG~~~~~~~~~~~~~~!telString:"+ telString);
        System.out.println("!~~~~~~~~~~~~~~~DEBUG~~~~~~~~~~~~~~!urlString:"+ urlString);

        callIcon = (ImageView)findViewById(R.id.call_image);
        callIcon.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+telString));
                if (callIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(callIntent);
                }
            }
        });

        // Set a click listener on web icon and send intent to browser
        webIcon = (ImageView) findViewById(R.id.website_image);
        webIcon.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlString));
                if (browserIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(browserIntent);
                }
            }
        });

        // Set a click listener on map icon and send intent to google map
        mapIcon = (ImageView) findViewById(R.id.map_image);
        mapIcon.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                //Launch Google Map and display the location
                Intent mapIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("geo:0,0?q="+ addressString));
                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                }
            }
        });

        assert actionBar != null;
        actionBar.setTitle(aName);
    }

    //Set back button to go back to previous page
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
