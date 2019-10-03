package com.examen.mvpsample.data.models;

import com.google.gson.annotations.SerializedName;

public class UserDto {

    @SerializedName("UserName")
    private String userName;

    @SerializedName("ID")
    private int iD;

    @SerializedName("Password")
    private String password;

    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getUserName(){
        return userName;
    }

    public void setID(int iD){
        this.iD = iD;
    }

    public int getID(){
        return iD;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return password;
    }

    @Override
    public String toString(){
        return
                "UserDto{" +
                        "userName = '" + userName + '\'' +
                        ",iD = '" + iD + '\'' +
                        ",password = '" + password + '\'' +
                        "}";
    }
}
