package com.staytouch.Profile;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.staytouch.R;
import com.staytouch.Utils.UniversalImageLoader;

public class EditProfileFragment extends Fragment {

    private static final String TAG = "EditProfileFragment";
    private ImageView mProfilePhoto;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit_profile, container, false);
        mProfilePhoto = (ImageView) view.findViewById(R.id.profile_photo);
        setProfileImage();

        // back arrow for navigating back to "Profile Activity"
        ImageView backArrow = (ImageView)view.findViewById(R.id.backArrow);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: navigating back to profile activity");
                getActivity().finish();
            }
        });
        return view;
    }



    private void setProfileImage(){
        Log.d(TAG, "setProfileImage: setting profile image.");
        String imageUrl = "images6.fanpop.com/image/photos/36600000/Sherlock-Holmes-Sherlock-BBC1-image-sherlock-holmes-sherlock-bbc1-36692648-267-400.jpg";
        UniversalImageLoader.setImage(imageUrl, mProfilePhoto, null, "http://");
    }
}
