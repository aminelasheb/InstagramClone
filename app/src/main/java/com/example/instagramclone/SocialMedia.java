package com.example.instagramclone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Toolbar;

import com.google.android.material.tabs.TabLayout;

public class SocialMedia extends AppCompatActivity {

    private ViewPager viewPager ;
    private androidx.appcompat.widget.Toolbar  toolbar;
    private TabLayout tabLayout ;
    private tabAdapter tabAdapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_media);

        setTitle("Social Media App !!!");
        toolbar=findViewById(R.id.toolbar) ;
        setSupportActionBar(toolbar);

        viewPager = findViewById(R.id.viewPager) ;
        tabAdapter = new tabAdapter(getSupportFragmentManager()) ;
        viewPager.setAdapter(tabAdapter);

        tabLayout = findViewById(R.id.TabLayout) ;
            tabLayout.setupWithViewPager(viewPager,false);


    }
}