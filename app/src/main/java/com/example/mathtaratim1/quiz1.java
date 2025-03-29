package com.example.mathtaratim1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class quiz1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_quiz1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button jawabanBenar = findViewById(R.id.button8);

        jawabanBenar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(quiz1.this, "Jawaban benar!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(quiz1.this, quiz2.class);
                startActivity(intent);
                finish();
            }
        });

        Button jawabanSalah1 = findViewById(R.id.button7);
        jawabanSalah1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(quiz1.this, "Jawaban salah!", Toast.LENGTH_SHORT).show();
            }
        });

        Button jawabanSalah2 = findViewById(R.id.button10);
        jawabanSalah2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(quiz1.this, "Jawaban salah!", Toast.LENGTH_SHORT).show();
            }
        });

        Button jawabanSalah3 = findViewById(R.id.button6);
        jawabanSalah3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(quiz1.this, "Jawaban salah!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}