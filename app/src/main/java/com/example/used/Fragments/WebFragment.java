package com.example.used.Fragments;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.used.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WebFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WebFragment extends Fragment {
    Button google, youtube, facebook, instagram, twitter, discord, spotify, traductor;
    private final static String GOOGLE_URL = "https://www.google.com/";
    private final static String YOUTUBE_URL = "https://www.youtube.com/";
    private final static String FACEBOOK_URL = "https://www.facebook.com/";
    private final static String INSTAGRAM_URL = "https://www.instagram.com/";
    private final static String TWITTER_URL = "https://twitter.com/?lang=en";
    private final static String DISCORD_URL = "https://discord.com/login";
    private final static String SPOTIFY_URL = "https://open.spotify.com/";
    private final static String TRANSLATE_URL = "https://translate.google.com/?hl=es&tab=TT";

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public WebFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WebFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WebFragment newInstance(String param1, String param2) {
        WebFragment fragment = new WebFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_web, container, false);

        google = view.findViewById(R.id.btnOpenGoogle);
        youtube = view.findViewById(R.id.btnOpenYoutube);
        facebook = view.findViewById(R.id.btnOpenFacebook);
        instagram = view.findViewById(R.id.btnOpenInstagram);
        twitter = view.findViewById(R.id.btnOpenTwitter);
        discord = view.findViewById(R.id.btnOpenDiscord);
        spotify = view.findViewById(R.id.btnOpenSpotify);
        traductor = view.findViewById(R.id.btnOpenTraductor);

        // Define el color que deseas para el botón
        int nuevoColor = getResources().getColor(R.color.jairo);

        // Establece el color de fondo del botón
        google.setBackgroundTintList(ColorStateList.valueOf(nuevoColor));
        youtube.setBackgroundTintList(ColorStateList.valueOf(nuevoColor));
        facebook.setBackgroundTintList(ColorStateList.valueOf(nuevoColor));
        instagram.setBackgroundTintList(ColorStateList.valueOf(nuevoColor));
        twitter.setBackgroundTintList(ColorStateList.valueOf(nuevoColor));
        discord.setBackgroundTintList(ColorStateList.valueOf(nuevoColor));
        spotify.setBackgroundTintList(ColorStateList.valueOf(nuevoColor));
        traductor.setBackgroundTintList(ColorStateList.valueOf(nuevoColor));

        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                switch (v.getId()){
                    case R.id.btnOpenGoogle:
                        intent.setData(Uri.parse(GOOGLE_URL));
                        startActivity(intent);
                        break;
                }
            }
        });

        youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                switch (v.getId()){
                    case R.id.btnOpenYoutube:
                        intent.setData(Uri.parse(YOUTUBE_URL));
                        startActivity(intent);
                        break;
                }
            }
        });

        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                switch (v.getId()){
                    case R.id.btnOpenFacebook:
                        intent.setData(Uri.parse(FACEBOOK_URL));
                        startActivity(intent);
                        break;
                }
            }
        });

        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                switch (v.getId()){
                    case R.id.btnOpenInstagram:
                        intent.setData(Uri.parse(INSTAGRAM_URL));
                        startActivity(intent);
                        break;
                }
            }
        });

        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                switch (v.getId()){
                    case R.id.btnOpenTwitter:
                        intent.setData(Uri.parse(TWITTER_URL));
                        startActivity(intent);
                        break;
                }
            }
        });

        discord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                switch (v.getId()){
                    case R.id.btnOpenDiscord:
                        intent.setData(Uri.parse(DISCORD_URL));
                        startActivity(intent);
                        break;
                }
            }
        });

        spotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                switch (v.getId()){
                    case R.id.btnOpenSpotify:
                        intent.setData(Uri.parse(SPOTIFY_URL));
                        startActivity(intent);
                        break;
                }
            }
        });

        traductor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                switch (v.getId()){
                    case R.id.btnOpenTraductor:
                        intent.setData(Uri.parse(TRANSLATE_URL));
                        startActivity(intent);
                        break;
                }
            }
        });
        return view;
    }
}