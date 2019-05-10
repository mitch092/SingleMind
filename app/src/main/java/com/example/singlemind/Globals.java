package com.example.singlemind;

import com.example.singlemind.backend.User.TransferObjects.User;

public class Globals {
    private static Globals mInstance= null;

    public User user;

    protected Globals(){}

    public static synchronized Globals getInstance() {
        if(null == mInstance){
            mInstance = new Globals();
        }
        return mInstance;
    }
}