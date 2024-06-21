package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {

    private EditText edusername, edpassword, edemail, edconfirmpassword;
    private Button btn;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        // Initialize UI elements
        initializeViews();

        // Set click listeners
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToLogin();
            }
        });
    }

    // Method to initialize UI elements
    private void initializeViews() {
        edusername = findViewById(R.id.editTextRegUsername);
        edemail = findViewById(R.id.editTextRegEmail);
        edpassword = findViewById(R.id.editTextRegPassword);
        edconfirmpassword = findViewById(R.id.editTextRegConfirmPassword);
        btn = findViewById(R.id.buttonR);
        tv = findViewById(R.id.textViewExistinguser);
    }

    // Method to handle user registration
    private void registerUser() {
        String username = edusername.getText().toString();
        String email = edemail.getText().toString();
        String confirmpassword = edconfirmpassword.getText().toString();
        String password = edpassword.getText().toString();

        if (username.isEmpty() || email.isEmpty() || password.isEmpty() || confirmpassword.isEmpty()) {
            showToast("Please fill all details");
        } else {
            if (password.equals(confirmpassword)) {
                if (isValidPassword(password)) {
                    // Save user data in the database
                    Database db = new Database(getApplicationContext(), "healthcare", null, 1);
                    db.register(username, email, password);
                    // You might want to add some feedback to the user here
                    showToast("Registration successful!");
                } else {
                    showToast("Password must contain at least 8 characters including letters, digits, and symbols");
                }
            } else {
                showToast("Password and Confirm Password do not match");
            }
        }
    }

    // Method to validate password
    private boolean isValidPassword(String password) {
        // Password must contain at least 8 characters including letters, digits, and symbols
        return password.length() >= 8 && password.matches("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]+$");
    }

    // Method to show toast messages
    private void showToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    // Method to navigate to the login activity
    private void navigateToLogin() {
        startActivity(new Intent(RegistrationActivity.this, LoginActivity.class));
    }
}
