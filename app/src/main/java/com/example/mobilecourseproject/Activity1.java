package com.example.mobilecourseproject;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Activity1 extends AppCompatActivity {

    ListView tietotekniikkaListView;
    String[] items;
    String[] descriptions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        if(getIntent().hasExtra("com.example.mobilecourseproject.PLACEHOLDER")) {
            TextView tv = findViewById(R.id.tietotekniikkaTextView);
            String text = getIntent().getExtras().getString("com.example.mobilecourseproject.PLACEHOLDER");
            tv.setText(text);
        }

        Resources res = getResources();
        tietotekniikkaListView = findViewById(R.id.tietotekniikkaListView);
        items = res.getStringArray(R.array.items);
        descriptions = res.getStringArray(R.array.descriptions);
        tietotekniikkaListView.setAdapter(new ArrayAdapter<>(this, R.layout.tietotekniikka_listview_detail, items));

        ItemAdapter itemAdapter = new ItemAdapter(this, items, descriptions);
        tietotekniikkaListView.setAdapter(itemAdapter);

    }
}