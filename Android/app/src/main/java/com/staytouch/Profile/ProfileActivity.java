package com.staytouch.Profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.staytouch.R;
import com.staytouch.Utils.BottomNavigationViewHelper;
import com.staytouch.Utils.GridImageAdapter;
import com.staytouch.Utils.UniversalImageLoader;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {
    private static final String TAG = "ProfileActivity";

    private Context mContext = ProfileActivity.this;
    private ProgressBar mProgressBar;
    private ImageView mProfilePhoto;

    private static final int ACTIVITY_NUM = 4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Log.d(TAG, "onCreate: started.");
        setupBottomNavigationView();
        setupToolbar();
        setupActivityWidgets();
        setProfileImage();
        tempGridSetup();
    }

    private void tempGridSetup() {
        ArrayList<String> imgUrls = new ArrayList<>();
        imgUrls.add("images6.fanpop.com/image/photos/36600000/Sherlock-Holmes-Sherlock-BBC1-image-sherlock-holmes-sherlock-bbc1-36692648-267-400.jpg");
        imgUrls.add("images6.fanpop.com/image/photos/36600000/Sherlock-Holmes-Sherlock-BBC1-image-sherlock-holmes-sherlock-bbc1-36692648-267-400.jpg");
        imgUrls.add("images6.fanpop.com/image/photos/36600000/Sherlock-Holmes-Sherlock-BBC1-image-sherlock-holmes-sherlock-bbc1-36692648-267-400.jpg");
        imgUrls.add("images6.fanpop.com/image/photos/36600000/Sherlock-Holmes-Sherlock-BBC1-image-sherlock-holmes-sherlock-bbc1-36692648-267-400.jpg");
        imgUrls.add("images6.fanpop.com/image/photos/36600000/Sherlock-Holmes-Sherlock-BBC1-image-sherlock-holmes-sherlock-bbc1-36692648-267-400.jpg");
        imgUrls.add("images6.fanpop.com/image/photos/36600000/Sherlock-Holmes-Sherlock-BBC1-image-sherlock-holmes-sherlock-bbc1-36692648-267-400.jpg");
        imgUrls.add("images6.fanpop.com/image/photos/36600000/Sherlock-Holmes-Sherlock-BBC1-image-sherlock-holmes-sherlock-bbc1-36692648-267-400.jpg");
        imgUrls.add("images6.fanpop.com/image/photos/36600000/Sherlock-Holmes-Sherlock-BBC1-image-sherlock-holmes-sherlock-bbc1-36692648-267-400.jpg");

        setupImageGrid(imgUrls);

    }

    private void setupImageGrid(ArrayList<String> imgUrls){
        GridView gridView = (GridView)findViewById(R.id.gridView);
        GridImageAdapter gridImageAdapter = new GridImageAdapter(mContext,
                                                                 R.layout.layout_grid_imageview,
                                                       "http://",
                                                                 imgUrls);
        gridView.setAdapter(gridImageAdapter);
    }

    private void setProfileImage(){
        Log.d(TAG, "setProfileImage: setting profile photo");
        String imageUrl = "images6.fanpop.com/image/photos/36600000/Sherlock-Holmes-Sherlock-BBC1-image-sherlock-holmes-sherlock-bbc1-36692648-267-400.jpg";
        UniversalImageLoader.setImage(imageUrl, mProfilePhoto, mProgressBar, "http://");
    }

    private void setupActivityWidgets(){
        mProgressBar = (ProgressBar) findViewById(R.id.profileProgressBar);
        mProgressBar.setVisibility(View.GONE);
        mProfilePhoto = (ImageView) findViewById(R.id.profile_photo);

    }

    private void setupToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.profileToolBar);
        setSupportActionBar(toolbar);

        ImageView profileMenu = (ImageView) findViewById(R.id.profileMenu);
        profileMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: navigating to account settings.");
                Intent intent = new Intent(mContext, AccountSettingsActivity.class);
                startActivity(intent);
            }
        });

    }

    private void setupBottomNavigationView(){
        Log.d(TAG, "setupBottomNavigationView: setting up bottom navigation view");
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottomNavViewBar);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
        BottomNavigationViewHelper.enableNavigation(mContext, bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }
    
}
