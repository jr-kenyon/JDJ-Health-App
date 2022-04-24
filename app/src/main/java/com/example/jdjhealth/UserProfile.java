package com.example.jdjhealth;

public class UserProfile {


    private final String username,password,email,name,fbUsername,fbPassword;
    public UserProfile(String username, String password, String name, String email, String fbUsername,String fbPassword){
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.fbUsername = fbUsername;
        this.fbPassword = fbPassword;
    }
    public String getUsername(){
        return this.username;
    }

    public String getPassword(){
        return this.password;
    }



    public String getEmail(){
        return this.email;
    }


    public String getName(){
        return this.name;
    }


    public String getFbUsername(){
        return this.fbUsername;
    }


    public String getFbPassword(){
        return this.fbPassword;
    }
}
