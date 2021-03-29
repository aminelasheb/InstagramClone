package com.example.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

public class SignUp extends AppCompatActivity {

    private EditText EdtUserNameSign ,EdtPasswordSign , EdtEmailSign ;
    private Button SignUpp ,Loginn ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        EdtUserNameSign = findViewById(R.id.edtUserNameSign) ;
        EdtPasswordSign = findViewById(R.id.edtPasswordSign) ;
        EdtEmailSign = findViewById(R.id.edtUserMail) ;
        SignUpp = findViewById(R.id.SignUpp) ;
        Loginn = findViewById(R.id.loginn) ;

        SignUpp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    ParseUser appUser = new ParseUser() ;
                appUser.setUsername(EdtUserNameSign.getText().toString());
                appUser.setPassword(EdtPasswordSign.getText().toString());
                appUser.setEmail(EdtEmailSign.getText().toString());

                //ProgressDialog
                    ProgressDialog progressDialog = new ProgressDialog(SignUp.this ) ;
                    progressDialog.setMessage("SignIn Up " + EdtUserNameSign.getText().toString());
                    progressDialog.show() ;

                appUser.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if(e==null) {
                            FancyToast.makeText(SignUp.this,"SignUp success", FancyToast.LENGTH_LONG,FancyToast.SUCCESS,true).show();
                        }

                        else {  FancyToast.makeText(SignUp.this,e.getMessage(), FancyToast.LENGTH_LONG,FancyToast.ERROR,true).show();

                        }  progressDialog.dismiss() ;
                }
                   }  )  ;
            }catch(Exception e) {
                    FancyToast.makeText(SignUp.this,e.getMessage(), FancyToast.LENGTH_LONG,FancyToast.ERROR,true).show();
                    Log.i("TAG", "onClick: "+e.getMessage());}

            }
        });

        Loginn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUp.this ,LogIn.class) ;
                startActivity(intent) ;

            }
        });
    }
}