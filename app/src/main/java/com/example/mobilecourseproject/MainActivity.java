package com.example.mobilecourseproject;


import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;



public class MainActivity extends AppCompatActivity {

    private CardView card_front, card_back;

    private Boolean isFront = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        SharedPreferences preferences = getSharedPreferences("AppPrefs", MODE_PRIVATE);
        boolean darkModeOn = preferences.getBoolean("dark_mode", false);

        if (darkModeOn) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }

        Switch switchNightmode = findViewById(R.id.switchNightmode);
        switchNightmode.setChecked(darkModeOn); // reflect saved state

        switchNightmode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {
                SharedPreferences.Editor editor = preferences.edit();
                editor.putBoolean("dark_mode", isChecked);
                editor.apply();

                if (isChecked) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
                recreate();
            }
        });

        // Profile picture Card flipper
        card_front = findViewById(R.id.cardView_front);
        card_back = findViewById(R.id.cardView_back);

        RelativeLayout profilePictureCard = findViewById(R.id.profilePictureCard);

        profilePictureCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flip_card_anim();
            }
        });

        //Attempts to launch another activity in the app
        TextView activityTV1 = findViewById(R.id.clickText1);
        activityTV1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), Activity1.class);
                startIntent.putExtra("com.example.mobilecourseproject.PLACEHOLDER", "Tietotekniikan opiskelija");
                startActivity(startIntent);
            }
        });

        TextView activityTV2 = findViewById(R.id.clickText2);
        activityTV2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), Activity2.class);
                startIntent.putExtra("com.example.mobilecourseproject.PLACEHOLDER", "Kuljetusalan ammattilainen");
                startActivity(startIntent);
            }
        });

        TextView activityTV3 = findViewById(R.id.clickText3);
        activityTV3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), Activity3.class);
                startIntent.putExtra("com.example.mobilecourseproject.PLACEHOLDER", "Urheilija");
                startActivity(startIntent);
            }
        });

        TextView activityTV4 = findViewById(R.id.clickText4);
        activityTV4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), Activity4.class);
                startIntent.putExtra("com.example.mobilecourseproject.PLACEHOLDER", "Tekijä");
                startActivity(startIntent);
            }
        });

        ImageView ivInstagram = findViewById(R.id.imageIcon1);
        ivInstagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String instagram = "http://www.instagram.com";
                Uri webAddress = Uri.parse(instagram);

                Intent goToInstagram = new Intent(Intent.ACTION_VIEW, webAddress);
                try {
                    startActivity(goToInstagram);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(v.getContext(), "No browser found.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ImageView ivFacebook = findViewById(R.id.imageIcon2);
        ivFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String facebook = "http://www.facebook.com";
                Uri webAddress = Uri.parse(facebook);

                Intent goToFacebook = new Intent(Intent.ACTION_VIEW, webAddress);
                try {
                    startActivity(goToFacebook);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(v.getContext(), "No browser found.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ImageView ivGithub = findViewById(R.id.imageIcon3);
        ivGithub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String github = "http://www.github.com";
                Uri webAddress = Uri.parse(github);

                Intent goToGithub = new Intent(Intent.ACTION_VIEW, webAddress);
                try {
                    startActivity(goToGithub);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(v.getContext(), "No browser found.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ImageView ivLinkedin = findViewById(R.id.imageIcon4);
        ivLinkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String linkedin = "http://www.linkedin.com";
                Uri webAddress = Uri.parse(linkedin);

                Intent goToLinkedin = new Intent(Intent.ACTION_VIEW, webAddress);
                try {
                    startActivity(goToLinkedin);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(v.getContext(), "No browser found.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ImageView ivSnapchat = findViewById(R.id.imageIcon5);
        ivSnapchat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String snapchat = "http://www.snapchat.com";
                Uri webAddress = Uri.parse(snapchat);

                Intent goToSnapchat = new Intent(Intent.ACTION_VIEW, webAddress);
                try {
                    startActivity(goToSnapchat);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(v.getContext(), "No browser found.", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    private void flip_card_anim() {
        AnimatorSet setOut = (AnimatorSet) AnimatorInflater.loadAnimator(MainActivity.this, R.animator.card_flip_out);
        AnimatorSet setIn = (AnimatorSet) AnimatorInflater.loadAnimator(MainActivity.this, R.animator.card_flip_in);

        setOut.setTarget(isFront ? card_front : card_back);
        setIn.setTarget(isFront ? card_back : card_front);

        setOut.start();
        setIn.start();
        isFront = !isFront;

    }

}