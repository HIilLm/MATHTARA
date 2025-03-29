package com.example.mathtaratim1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class cerita1e2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cerita1e2);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button toHome = findViewById(R.id.button5);
        toHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Simpan achievement ke SharedPreferences sebelum pindah ke prestory
                saveAchievement();

                // Pindah ke halaman prestory
                Intent toHome = new Intent(cerita1e2.this, prestory.class);
                startActivity(toHome);
                finish(); // Tutup activity ini agar tidak kembali ke sini lagi
            }
        });
    }

    // Metode untuk menyimpan achievement
    private void saveAchievement() {
        SharedPreferences prefs = getSharedPreferences("Achievements", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("achievement_story_1", true); // Simpan sebagai "achievement unlocked"
        editor.apply();
    }
}
