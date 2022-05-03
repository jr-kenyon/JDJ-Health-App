package com.example.jdjhealth;

import static com.example.jdjhealth.Tools.sendAlert;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

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

        UserProfileDao dao = UserProfileDatabase.getSingleton(this).userProfileDao();
        UserProfile user = dao.get(username);

        if(user == null) {
            sendAlert(this, "Username is not registered");
            return;
        }

        if(!user.getPassword().equals(password)) {
            sendAlert(this, "Incorrect Password");
        }
        else{
            Intent intent = new Intent(this, MenuActivity.class);
            startActivity(intent);
        }
    }

    public void onRegisterClicked(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

}