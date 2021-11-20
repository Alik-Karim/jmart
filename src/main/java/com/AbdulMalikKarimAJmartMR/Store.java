package com.AbdulMalikKarimAJmartMR;

import com.AbdulMalikKarimAJmartMR.dbjson.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Store extends Serializable
{
    public static final String REGEX_PHONE = "^\\d{9,12}$";
    public static final String REGEX_NAME = "^[A-Z](?!.*(\\s)\\1).{4,20}$";
    
    public String name;
    public String address;
    public String phoneNumber;


    public Store(int accountId, String name, String address, String phoneNumber) {
//        super(accountId);
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Store(String name, String address, String phoneNumber) {
        this.name =name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }


    public String toString() {
        return "name: " + name + "\naddress: " + address + "\nphoneNumber: " + phoneNumber;
    }

    public boolean validate() {
        Pattern pattern = Pattern.compile(REGEX_NAME);
        Matcher matcher = pattern.matcher(name);
        Pattern pattern2 = Pattern.compile(REGEX_PHONE);
        Matcher matcher2 = pattern2.matcher(phoneNumber);
        return matcher.find() && matcher2.find();
    }

}