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

public class quiz2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_quiz2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button jawabanBenar = findViewById(R.id.button6);
        Button jawabanSalah = findViewById(R.id.button7);
        Button jawabanSalah2 = findViewById(R.id.button8);
        Button jawabanSalah3 = findViewById(R.id.button10);

        jawabanSalah.setOnClickListener(new  View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(quiz2.this, "Jawaban Salah", Toast.LENGTH_SHORT).show();
            }
        });

        jawabanSalah2.setOnClickListener(new  View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(quiz2.this, "Jawaban Salah", Toast.LENGTH_SHORT).show();
            }
        });

        jawabanSalah3.setOnClickListener(new  View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(quiz2.this, "Jawaban Salah", Toast.LENGTH_SHORT).show();
            }
        });


        jawabanBenar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toQuiz3 = new Intent(quiz2.this, quiz3.class);
                startActivity(toQuiz3);
            }
        });
    }
}