package com.yair.android5780.Entities;

/**
 * Created by Yair on 04/12/2019.
 */
public class Recipient {
    static int s_id = 0;
    private int recipientID;
    private String recipientName;


    public Recipient(String recipientName) {
        recipientID = s_id;
        ++s_id;
        this.recipientName = recipientName;
    }
}

