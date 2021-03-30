package com.example.instagramclone;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

public class LogIn extends AppCompatActivity {

    private EditText EdtUserName, EdtPassword;
    private Button SignUp, Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EdtUserName = findViewById(R.id.edtUserName);
        EdtPassword = findViewById(R.id.edtPassword);
        Login = findViewById(R.id.login);
        SignUp = findViewById(R.id.SignUp);

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LogIn.this, SignUp.class);
                startActivity(intent);
            }
        });


//        SignUp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ParseUser appUser = new ParseUser() ;
//                appUser.setUsername(EdtUserName.getText().toString());
//                appUser.setPassword(EdtPassword.getText().toString());
//
//                appUser.signUpInBackground(new SignUpCallback() {
//                    @Override
//                    public void done(ParseException e) {
//                        if(e==null) {
//                            FancyToast.makeText(Sign.this,"SignUp success", FancyToast.LENGTH_LONG,FancyToast.SUCCESS,true).show();
//                        }
//
//                        else {                            FancyToast.makeText(Sign.this,e.getMessage(), FancyToast.LENGTH_LONG,FancyToast.ERROR,true).show();
//
//                        }
//                }}  )  ;
//            }
//        });

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ParseUser.logInInBackground(EdtUserName.getText().toString(), EdtPassword.getText().toString(), new LogInCallback() {
                    @Override
                    public void done(ParseUser user, ParseException e) {
                        if (user != null && e == null) {
                            FancyToast.makeText(LogIn.this, "LogIn success", FancyToast.LENGTH_LONG, FancyToast.SUCCESS, true).show();
//                            Intent intent = new Intent(LogIn.this, Welcome.class);
//                            startActivity(intent);

                            transitionSocialMediaActivity () ;

                        } else {
                            FancyToast.makeText(LogIn.this, e.getMessage(), FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();

                        }


                    }
                });
            }
        });


    }

    // hiding the keybord
    public void click(View view) {
        try {
            InputMethodManager input = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            input.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /*public void HelloWorldTapped(View view) {
        ParseObject boxer = new ParseObject("Boxer");
       boxer.put("Speed", 200);
       boxer.saveInBackground(new SaveCallback() {
           @Override
          public void done(ParseException e) { // e : error ;
             if (e == null) {

                 FancyToast.makeText(Sign.this,"Hello World !", FancyToast.LENGTH_LONG,FancyToast.SUCCESS,true).show();
             } }
         });
    }*/

   private void transitionSocialMediaActivity () {
Intent intent = new Intent(LogIn.this ,SocialMedia.class) ;
startActivity(intent) ;


   }
}