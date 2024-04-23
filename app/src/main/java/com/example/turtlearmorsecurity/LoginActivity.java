// Activity class
package com.example.turtlearmorsecurity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.FirebaseApp;

import androidx.appcompat.app.AppCompatActivity;


public class LoginActivity extends AppCompatActivity {

    private EditText editTextUsernameOrEmail;
    private EditText editTextPassword;
    private Button buttonLogin;
    private Button buttonRegister;

    private PasswordDBHelper dbHelper;
    private PhoneAuth phoneAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        FirebaseApp.initializeApp(this);

        dbHelper = new PasswordDBHelper(this);
        phoneAuth = new PhoneAuth(this);

        // Initialize UI components
        editTextUsernameOrEmail = findViewById(R.id.editTextUsernameOrEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        Button buttonLogin = findViewById(R.id.buttonLogin);
        Button buttonRegister = findViewById(R.id.buttonRegister);

        buttonRegister.setOnClickListener(v -> startActivity(new Intent(LoginActivity.this, RegistrationActivity.class)));

        // Set click listener for login button
        buttonLogin.setOnClickListener(v -> {
            String username = editTextUsernameOrEmail.getText().toString();
            String password = editTextPassword.getText().toString();

            if (isValid(username, password)) {
                PhoneAuth phoneAuth = new PhoneAuth(this);
                phoneAuth.sendOTP("+15551234567");
            } else {
                Toast.makeText(LoginActivity.this, "Invalid " +
                        "username or password", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean isValid(String username, String password) {
        return !username.isEmpty() && !password.isEmpty();
    }

}