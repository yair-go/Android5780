package com.yair.android5780.Entities;

import android.icu.text.SimpleDateFormat;
import android.location.Location;

import java.util.Date;

import androidx.annotation.NonNull;

/**
 * Created by Yair on 04/12/2019.
 */
public class ParcelDetails  {
    private int id;
    private Enums.ParcelStatus parcelStatus;
    private Enums.ParcelType parcelType;
    private Enums.ParcelWeight parcelWeight;
    private Location location;
    private Recipient recipient;
    private Date shippingDate;

    public ParcelDetails(int id, Enums.ParcelStatus parcelStatus, Enums.ParcelType parcelType, Enums.ParcelWeight parcelWeight, Location location, Recipient recipient) {
        this.id = id;
        this.parcelStatus = parcelStatus;
        this.parcelType = parcelType;
        this.parcelWeight = parcelWeight;
        this.location = location;

        this.recipient = recipient;
        this.shippingDate = new Date();
    }

    public ParcelDetails(ParcelFromFirebase parceldb)  {
        this.id  = parceldb.id;
        try {
            this.shippingDate = new SimpleDateFormat("dd/MM/yyyy").parse(parceldb.shippingDate);
        }
        catch (Exception e){
            this.shippingDate = new Date();
        }
        this.parcelStatus =  Enums.ParcelStatus.valueOf(parceldb.status);
        this.parcelType =  Enums.ParcelType.valueOf(parceldb.type);
        this.parcelWeight =  Enums.ParcelWeight.valueOf(parceldb.weight);
    }

    public Enums.ParcelStatus getParcelStatus() {
        return parcelStatus;
    }

    public Enums.ParcelType getParcelType() {
        return parcelType;
    }

    public Enums.ParcelWeight getParcelWeight() {
        return parcelWeight;
    }
    @NonNull
    @Override
    public String toString() {
        return ((Integer) id).toString() + ": " + shippingDate.toString();
    }

}
