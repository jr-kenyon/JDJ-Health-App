package com.example.jdjhealth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);
    }

    public void onSubmitButtonClicked(View view) {
        TextView nameView = findViewById(R.id.tvAccountName);
        TextView emailView = findViewById(R.id.tvAccountEmail);
        TextView usernameView = findViewById(R.id.tvAccountUsername);
        TextView passwordView = findViewById(R.id.tvAccountPassword);
        TextView fbUsernameView = findViewById(R.id.tvFitBitUsername);
        TextView fbPasswordView = findViewById(R.id.tvFitBitPassword);

        String name = nameView.getText().toString();
        String email = emailView.getText().toString();
        String username = usernameView.getText().toString();
        String password = passwordView.getText().toString();
        String fbUsername = fbUsernameView.getText().toString();
        String fbPassword = fbPasswordView.getText().toString();

        UserProfile user = new UserProfile(username, password, name, email, fbUsername, fbPassword);

        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        Gson gson = new Gson();
        String json = gson.toJson(user);
        editor.putString(username, json);
        editor.apply();

        finish();
    }
}