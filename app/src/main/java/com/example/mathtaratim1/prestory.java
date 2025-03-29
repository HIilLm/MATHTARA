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
    Boolean saved = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_prestory);

        Button toCerita = findViewById(R.id.button);
        ImageView save = findViewById(R.id.imageView21);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saved = !saved;
                if (saved) {
                save.setImageResource(R.drawable.baseline_bookmark_24);
                }
            }
        });
        toCerita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cerita = new Intent(getApplicationContext(), cerita1s1.class);
                startActivity(cerita);
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
                intent.putExtra("saved", saved);
                startActivity(intent);
            }
        });
    }
}
