package com.yair.android5780.Entities;

import androidx.annotation.NonNull;

/**
 * Created by Yair on 09/12/2019.
 */
public class ParcelFromFirebase {
    public int id;
    public String shippingDate;
    public String status;
    public String type;
    public String weight;
    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }
}
