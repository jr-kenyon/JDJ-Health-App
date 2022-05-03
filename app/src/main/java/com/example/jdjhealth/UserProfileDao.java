package com.example.jdjhealth;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserProfileDao {
    @Insert
    long insert(UserProfile userProfile);

    @Query("SELECT * FROM userprofiles WHERE username=:username")
    UserProfile get(String username);

    @Query("SELECT * FROM userprofiles")
    List<UserProfile> getAll();

    @Update
    int update(UserProfile userProfile);

    @Delete
    int delete(UserProfile userProfile);

}
