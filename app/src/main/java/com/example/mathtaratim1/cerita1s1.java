package com.example.mathtaratim1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class cerita1s1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cerita1s1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button terima = findViewById(R.id.button4);
        Button tolak = findViewById(R.id.button5);

        terima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toS2 = new Intent(cerita1s1.this, cerita1s2.class);
                startActivity(toS2);
            }
        });

        tolak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toS3 = new Intent(cerita1s1.this, cerita1s3.class);
                startActivity(toS3);
            }
        });
    }
}