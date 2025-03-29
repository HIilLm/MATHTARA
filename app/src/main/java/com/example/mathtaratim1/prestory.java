package com.example.mathtaratim1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class prestory extends AppCompatActivity {

    Button next_cerita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_prestory);

        next_cerita = (Button) findViewById(R.id.button);

        next_cerita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next_cerita = new Intent(getApplicationContext(), cerita1s1.class);
                startActivity(next_cerita);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageView goBack = findViewById(R.id.imageView20);
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(prestory.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
