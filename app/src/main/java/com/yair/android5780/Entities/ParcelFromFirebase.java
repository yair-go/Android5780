package com.yair.android5780.Entities;

import androidx.annotation.NonNull;

/**
 * Created by Yair on 09/12/2019.
 */
public class ParcelFromFirebase {
    public int id;
    public String shippingDate;

//    public String parcelStatus;
//    public String parcelType;
//    public String parcelWeight;

    public Enums.ParcelStatus parcelStatus;
    public Enums.ParcelType parcelType;
    public Enums.ParcelWeight parcelWeight;
    public Double latitude;
    public Double longitude;
    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }
}
