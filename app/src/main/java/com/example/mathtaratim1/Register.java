package com.example.mathtaratim1;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Register extends AppCompatActivity {

    private EditText username, email, password, repassword;
    private Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        username = (EditText) findViewById(R.id.username);
        email = (EditText) findViewById(R.id.editTextTextEmailAddress);
        password = (EditText) findViewById(R.id.password);
        repassword = (EditText) findViewById(R.id.repassword);
        signup = (Button) findViewById(R.id.signup);

        username = findViewById(R.id.username);
        email = findViewById(R.id.editTextTextEmailAddress);
        password = findViewById(R.id.password);
        repassword = findViewById(R.id.repassword);
        signup = findViewById(R.id.signup);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void registerUser() {
        String name = username.getText().toString().trim();
        String emailText = email.getText().toString().trim();
        String pass = password.getText().toString().trim();
        String rePass = repassword.getText().toString().trim();

        if (TextUtils.isEmpty(name)) {
            username.setError("Name is required");
            return;
        }
        if (TextUtils.isEmpty(emailText)) {
            email.setError("Email is required");
            return;
        }
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(emailText).matches()) {
            email.setError("Invalid email format");
            return;
        }
        if (TextUtils.isEmpty(pass)) {
            password.setError("Password is required");
            return;
        }
        if (pass.length() < 6) {
            password.setError("Password must be at least 6 characters");
            return;
        }
        if (!pass.equals(rePass)) {
            repassword.setError("Passwords do not match");
            return;
        }

        Toast.makeText(this, "Registration successful!", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(Register.this, Login.class));
        finish();
    }
}
