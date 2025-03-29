package com.example.mathtaratim1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Login extends AppCompatActivity {

    private Button login, createAcc;
    private EditText email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        initViews();
        setupListeners();
        applyWindowInsets();
    }

    private void initViews() {
        email = findViewById(R.id.editTextTextEmailAddress);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        createAcc = findViewById(R.id.create);
    }

    private void setupListeners() {
        login.setOnClickListener(v -> attemptLogin());
        createAcc.setOnClickListener(v -> startActivity(new Intent(Login.this, Register.class)));
    }

    private void attemptLogin() {
        String enteredEmail = email.getText().toString().trim();
        String enteredPassword = password.getText().toString().trim();

        if (enteredEmail.isEmpty()) {
            email.setError("Email tidak boleh kosong!");
            return;
        }
        if (enteredPassword.isEmpty()) {
            password.setError("Password tidak boleh kosong!");
            return;
        }
        if (checkLogin(enteredEmail, enteredPassword)) {
            showToast("Login berhasil!");
            startActivity(new Intent(Login.this, MainActivity.class));
            finish();
        } else {
            showToast("Email atau password salah!");
        }
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private boolean checkLogin(String email, String password) {
        return "user@example.com".equals(email) && "password123".equals(password);
    }

    private void applyWindowInsets() {
        View rootView = findViewById(R.id.main);
        if (rootView != null) {
            ViewCompat.setOnApplyWindowInsetsListener(rootView, (v, insets) -> {
                v.setPadding(
                        insets.getInsets(WindowInsetsCompat.Type.systemBars()).left,
                        insets.getInsets(WindowInsetsCompat.Type.systemBars()).top,
                        insets.getInsets(WindowInsetsCompat.Type.systemBars()).right,
                        insets.getInsets(WindowInsetsCompat.Type.systemBars()).bottom
                );
                return insets;
            });
        }
    }
}