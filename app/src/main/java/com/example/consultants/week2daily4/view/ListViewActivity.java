package com.example.consultants.week2daily4.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.consultants.week2daily4.R;

public class ListViewActivity extends AppCompatActivity {

    static final String[] CATEGORIES = new String[]{"MAMMALS", "BIRDS", "FISH", "REPTILES"};
    private ListView lvCategories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        lvCategories = findViewById(R.id.lvCategories);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,
                R.layout.category_view, CATEGORIES);
        lvCategories.setAdapter(arrayAdapter);
        lvCategories.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), RecyclerViewActivity.class);
                String message = CATEGORIES[position];
                intent.putExtra("CATEGORY", message);
                startActivity(intent);
                }
        });

    }
}


