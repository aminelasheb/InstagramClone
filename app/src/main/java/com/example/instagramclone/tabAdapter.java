package com.example.instagramclone;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.instagramclone.ProfileTab;
import com.example.instagramclone.SharePictureTab;
import com.example.instagramclone.UsersTab;

public class tabAdapter extends FragmentPagerAdapter {


    public tabAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int tabPosition) {
        switch (tabPosition) {
            case (0):
                ProfileTab profileTab = new ProfileTab();
                return profileTab;
            case (1):
                UsersTab usersTab = new UsersTab();
                return usersTab;
            case (2):
                SharePictureTab sharePictureTab = new SharePictureTab();
                return sharePictureTab;
            default:return null ;
        }
    }

    @Override
    public int getCount() {
        return 3;  //3tabs in tablayout
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case(0) : return "Profile ";
            case(1): return "Users";
            case(2) : return "Share Pictures";
            default:return null ;
        }
    }
}
