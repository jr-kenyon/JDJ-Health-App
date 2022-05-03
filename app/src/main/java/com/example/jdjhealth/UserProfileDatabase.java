package com.example.jdjhealth;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {UserProfile.class}, version = 1)
public abstract class UserProfileDatabase extends RoomDatabase {
    private static UserProfileDatabase singleton = null;

    public abstract UserProfileDao userProfileDao();

    public synchronized static UserProfileDatabase getSingleton(Context context) {
        if(singleton == null) {
            singleton = UserProfileDatabase.makeDatabase(context);
        }
        return singleton;
    }

    private static UserProfileDatabase makeDatabase(Context context) {
        return Room.databaseBuilder(context, UserProfileDatabase.class, "user_app.db")
                .build();
    }
}
