package com.example.contactmanagementsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    CardView notification, contact_info, profile, emar_cont, maps, logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notification = (CardView) findViewById(R.id.notification);
        contact_info = (CardView) findViewById(R.id.contact_info);
        profile = (CardView) findViewById(R.id.profile);
        emar_cont = (CardView) findViewById(R.id.emargency);
        maps = (CardView) findViewById(R.id.maps);
        logout = (CardView) findViewById(R.id.logout);

        notification.setOnClickListener(this);
        contact_info.setOnClickListener(this);
        profile.setOnClickListener(this);
        emar_cont.setOnClickListener(this);
        maps.setOnClickListener(this);
        logout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.notification:
                Toast.makeText(MainActivity.this, "notification", Toast.LENGTH_LONG).show();
                break;

            case R.id.contact_info:
                Toast.makeText(MainActivity.this, "contact_info", Toast.LENGTH_LONG).show();
                break;
            case R.id.profile:
                Toast.makeText(MainActivity.this, "profile", Toast.LENGTH_LONG).show();
                break;
            case R.id.maps:
                Toast.makeText(MainActivity.this, "maps", Toast.LENGTH_LONG).show();
                break;
            case R.id.emargency:
                Toast.makeText(MainActivity.this, "emargency", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this, EmargencyContact.class);
                startActivity(intent);
                break;
            case R.id.logout:
                Toast.makeText(MainActivity.this, "logout", Toast.LENGTH_LONG).show();
                break;
            default:
                Toast.makeText(MainActivity.this, "Default", Toast.LENGTH_LONG).show();
                break;
        }

    }
}
