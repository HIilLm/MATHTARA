package com.example.mathtaratim1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Login extends AppCompatActivity {

    Button login;
    Button createacc;
    TextView email;
    TextView password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        email = (TextView) findViewById(R.id.editTextTextEmailAddress);
        password = (TextView) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
        createacc = (Button) findViewById(R.id.create);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            v.setPadding(insets.getInsets(WindowInsetsCompat.Type.systemBars()).left,
                    insets.getInsets(WindowInsetsCompat.Type.systemBars()).top,
                    insets.getInsets(WindowInsetsCompat.Type.systemBars()).right,
                    insets.getInsets(WindowInsetsCompat.Type.systemBars()).bottom);
            return insets;
        });
    }

    private void setupListeners() {
        login.setOnClickListener(v -> attemptLogin());
        createacc.setOnClickListener(v -> startActivity(new Intent(Login.this, Register.class)));
    }

    private void attemptLogin() {
        String enteredEmail = email.getText().toString().trim();
        String enteredPassword = password.getText().toString().trim();

        if (enteredEmail.isEmpty()) {
            showToast("Email tidak boleh kosong!");
        } else if (enteredPassword.isEmpty()) {
            showToast("Password tidak boleh kosong!");
        } else if (checkLogin(enteredEmail, enteredPassword)) {
            showToast("Login berhasil!");
            startActivity(new Intent(Login.this, HomeFragment.class));
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
}
