package ru.gb.calculatorcaller;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    private final String URI = "example://intent";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.go_to_calc);
        button.setOnClickListener(x -> {
            Uri uri = Uri.parse(URI);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            ActivityInfo activityInfo = intent.resolveActivityInfo(getPackageManager(), intent.getFlags());
            if (activityInfo != null) {
                startActivity(intent);
            }
        });
    }
}