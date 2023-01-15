package com.myrh.utils;

public class RandomCode {

    public static int generate(){
        return (int)Math.floor(Math.random()*(99999-9999+1)+9999);
    }
}
