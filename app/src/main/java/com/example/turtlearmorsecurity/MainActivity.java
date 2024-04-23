// Turtle Armor Security version 1.9
// Activity class
package com.example.turtlearmorsecurity;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private PasswordDBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new PasswordDBHelper(this);

        // Check if the user is logged in (e.g., check if session token exists)
        if (isLoggedIn()) {
            // User is logged in, navigate to the main screen or home activity
            startActivity(new Intent(MainActivity.this, HomeActivity.class));
            finish();
            // Finish MainActivity to prevent returning to it by pressing back button
        } else {
            // User is not logged in, navigate to the login activity
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
            finish();
            // Finish MainActivity to prevent returning to it by pressing back button
        }
    }

    private boolean isLoggedIn() {
        // Check if user is logged in by checking if there is any user data in the database
        // You can implement your own logic to check if the user is logged in based on your authentication mechanism
        //For example, you can check if there is a session token, or if the user is already authenticated in the current session
        // For simplicity, this example checks if there is any user data in the database
        return dbHelper.getUserCount() > 0;
    }


}
