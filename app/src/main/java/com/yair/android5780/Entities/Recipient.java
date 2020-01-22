package com.yair.android5780.Entities;

/**
 * Created by Yair on 04/12/2019.
 */
public class Recipient {
    static int s_id = 0;
    private int recipientID;
    private String recipientName;



    private String PhoneNumber;

    public int getRecipientID() {
        return recipientID;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public Recipient(String recipientName) {
        recipientID = s_id;
        ++s_id;
        this.recipientName = recipientName;
    }
    public Recipient(int recipientID, String recipientName, String phoneNumber) {
        this.recipientID = recipientID;
        this.recipientName = recipientName;
        PhoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public void setRecipientID(int recipientID) {
        this.recipientID = recipientID;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }
}

