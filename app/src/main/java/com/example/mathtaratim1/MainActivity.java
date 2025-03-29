package com.example.mathtaratim1;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity implements
        NavigationBarView.OnItemSelectedListener, ShopFragment.OnGemPurchaseListener {

    private BottomNavigationView bottomNavigationView;
    private ShopFragment shopFragment = new ShopFragment();
    private GearFragment gearFragment = new GearFragment();
    private HomeFragment homeFragment = new HomeFragment();
    private CollectionFragment collectionFragment = new CollectionFragment();
    private FavoriteFragment favoriteFragment = new FavoriteFragment();

    private int totalGems = 0; // Awalnya 0
    private TextView gemTextView; // TextView untuk menampilkan jumlah gems
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        imageView = findViewById(R.id.avatar);
        imageView.setOnClickListener(v -> {
            Intent regist = new Intent(MainActivity.this, Login.class);
            startActivity(regist);
        });

        gemTextView = findViewById(R.id.gem); // Hubungkan dengan TextView navbar
        updateGemText(); // Tampilkan jumlah awal gems

        bottomNavigationView = findViewById(R.id.bottomView);
        getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, homeFragment).commit();
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.shop) {
            getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, shopFragment).commit();
            return true;
        } else if (itemId == R.id.gear) {
            getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, gearFragment).commit();
            return true;
        } else if (itemId == R.id.home) {
            getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, homeFragment).commit();
            return true;
        } else if (itemId == R.id.collection) {
            getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, collectionFragment).commit();
            return true;
        } else if (itemId == R.id.favorite) {
            getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, favoriteFragment).commit();
            return true;
        }
        return false;
    }

    // Menerima jumlah gems dari ShopFragment
    @Override
    public void onGemPurchased(int gems) {
        totalGems += gems; // Tambahkan jumlah gems
        updateGemText(); // Update TextView di navbar
    }

    private void updateGemText() {
        gemTextView.setText(String.valueOf(totalGems)); // Perbarui teks di navbar
    }

}
