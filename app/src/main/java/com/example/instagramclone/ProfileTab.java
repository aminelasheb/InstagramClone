package com.example.instagramclone;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.shashank.sony.fancytoastlib.FancyToast;


public class  ProfileTab extends Fragment {

  private EditText PName ,PBio ,PProfession ,PHobies ,PSport  ;
  private Button Edit ;

    public ProfileTab() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_profile_tab, container, false);
        PName = view.findViewById(R.id.ProfileName) ;
        PBio = view.findViewById(R.id.Bio) ;
        PProfession = view.findViewById(R.id.Profession) ;
        PHobies = view.findViewById(R.id.Hobies) ;
        PSport = view.findViewById(R.id.Sport) ;
        Edit = view.findViewById(R.id.Update) ;


        ParseUser parseUser = ParseUser.getCurrentUser() ;

        Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                parseUser.put ("ProfileName",PName.getText().toString()) ;
                parseUser.put ("Bio",PBio.getText().toString()) ;
                parseUser.put ("Profession",PProfession.getText().toString()) ;
                parseUser.put ("Hobies",PHobies.getText().toString()) ;
                parseUser.put ("Sport",PSport.getText().toString()) ;

                parseUser.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e==null) {
                            FancyToast.makeText(getContext(),"Infos Updated", FancyToast.LENGTH_LONG, FancyToast.SUCCESS, true).show();
                        } else
                        { FancyToast.makeText(getContext(), e.getMessage(), FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show(); }

                    }
                });



            }
        });
    return view ;}


}