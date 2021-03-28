package com.example.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.parse.ParseUser;

import org.w3c.dom.Text;

public class Welcome extends AppCompatActivity {

    private TextView Welcome ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Welcome = findViewById(R.id.welc) ;
        Welcome.setText("Welcome \n"+ ParseUser.getCurrentUser().get("username"));

    }

    public void logout(View view) {
        ParseUser.logOut();
        Intent intent = new Intent(Welcome.this ,Sign.class) ;
        startActivity(intent) ;

    }
}