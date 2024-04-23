// Activity class
package com.example.turtlearmorsecurity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Initialize UI components
        Button loginButton = findViewById(R.id.login_button);

        // Set click listener for logout button
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,LoginActivity.class));
            }
        });
    }

    private void logoutUser() {
        // TODO: Implement logout logic
        // For example, clear session data and navigate back to the login screen
        // Here's a placeholder for navigating back to the login screen:
        startActivity(new Intent(HomeActivity.this, LoginActivity.class));
        finish();
        // Finish HomeActivity to prevent returning to it by pressing back button
    }
}
