package com.example.consultants.week2daily4;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.consultants.week2daily4.model.AnimalGenerator;
import com.example.consultants.week2daily4.view.ListViewActivity;

public class MainActivity extends AppCompatActivity {
    TextView tvResult;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prefs = getSharedPreferences("zooAppPrefs", MODE_PRIVATE);

        tvResult = findViewById(R.id.tvResult);
    }

    @Override
    protected void onResume() {
        super.onResume();

        //using sharedprefs to check if first run, to populateDB only once
        if (prefs.getBoolean("firstrun", true)) {
            populateDB();
            prefs.edit().putBoolean("firstrun", false).commit();
        }
    }

    public void goToCategories(View view) {
        Intent intent = new Intent(getApplicationContext(), ListViewActivity.class);
        startActivity(intent);
    }

    private void populateDB() {

        AnimalGenerator animalGenerator = new AnimalGenerator();
        animalGenerator.populateDB(this);

    }

}
