package com.example.jdjhealth;

import static com.example.jdjhealth.Tools.sendAlert;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onLoginClicked(View view) {
        TextView usernameView = findViewById(R.id.tvUsername);
        TextView passwordView = findViewById(R.id.tvPassword);

        String username = usernameView.getText().toString();
        String password = passwordView.getText().toString();

        if(username.equals("")) {
            sendAlert(this, "Must enter a Username");
            return;
        }

        if(password.equals("")) {
            sendAlert(this, "Must enter a Password");
            return;
        }

        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        String passKey = preferences.getString(username, "");

        if(passKey.equals("")) {
            sendAlert(this, "Username does not Exist");
            return;
        }

        if(!passKey.equals(password)) {
            sendAlert(this, "Incorrect Password");
            return;
        }
        else{
            Intent intent = new Intent(this, MenuActivity.class);
            startActivity(intent);
            return;
        }
    }

    public void onRegisterClicked(View view) {
        TextView usernameView = findViewById(R.id.tvUsername);
        TextView passwordView = findViewById(R.id.tvPassword);

        String username = usernameView.getText().toString();
        String password = passwordView.getText().toString();

        if(username.equals("")) {
            sendAlert(this, "Must enter a Username");
            return;
        }

        if(password.equals("")) {
            sendAlert(this, "Must enter a Password");
            return;
        }

        SharedPreferences preferences = getPreferences(MODE_PRIVATE);

        String passKey = preferences.getString(username, "");
        if(!passKey.equals("")) {
            sendAlert(this, "Username already exists");
        }
        else{
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString(username, password);

            editor.apply();
        }

    }

}