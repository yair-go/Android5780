package com.yair.android5780.Entities;

import android.location.Location;

import java.text.SimpleDateFormat;
import java.util.Date;

import androidx.annotation.NonNull;

/**
 * Created by Yair on 04/12/2019.
 */
public class ParcelDetails  {
    private int id;
    private static int s_id = 0;
    private Enums.ParcelStatus parcelStatus;
    private Enums.ParcelType parcelType;
    private Enums.ParcelWeight parcelWeight;
    private Location location;
    private Recipient recipient;
    private Date shippingDate;

    //region Ctors
    public ParcelDetails(Enums.ParcelStatus parcelStatus, Enums.ParcelType parcelType, Enums.ParcelWeight parcelWeight, Recipient recipient) {
        this.id = s_id++;
        this.parcelStatus = parcelStatus;
        this.parcelType = parcelType;
        this.parcelWeight = parcelWeight;
        this.location = new Location("");
        location.setLatitude(31.765739);
        location.setLongitude(35.191110);

        this.recipient = recipient;
        this.shippingDate = new Date();
    }

    public ParcelDetails(ParcelFromFirebase parceldb)  {
        this.id  = parceldb.id;
       // this.shippingDate = parceldb.shippingDate;
        try {
            this.shippingDate = new SimpleDateFormat("dd/MM/yyyy").parse(parceldb.shippingDate);
        }
        catch (Exception e){
            this.shippingDate = new Date();
        }
//        this.parcelStatus =  Enums.ParcelStatus.valueOf(parceldb.parcelStatus);
//        this.parcelType =  Enums.ParcelType.valueOf(parceldb.parcelType);
//        this.parcelWeight =  Enums.ParcelWeight.valueOf(parceldb.parcelWeight);
        this.parcelStatus = parceldb.parcelStatus;
        this.parcelType = parceldb.parcelType;
        this.parcelWeight = parceldb.parcelWeight;

        location = new Location("");
        location.setLatitude(parceldb.latitude);
        location.setLongitude(parceldb.longitude);
    }
//endregion

    //region Getters
    public int getId() {
        return id;
    }

    public String getShippingDate() {
        return new SimpleDateFormat("dd/MM/yyyy").format(shippingDate);
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
    public Double getLatitude(){
        return location.getLatitude();
    }
    public Double getLongitude(){
        return location.getLongitude();
    }

    //endregion

    //region Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setParcelStatus(Enums.ParcelStatus parcelStatus) {
        this.parcelStatus = parcelStatus;
    }

    public void setParcelType(Enums.ParcelType parcelType) {
        this.parcelType = parcelType;
    }

    public void setParcelWeight(Enums.ParcelWeight parcelWeight) {
        this.parcelWeight = parcelWeight;
    }

    public void setShippingDate(Date shippingDate) {
        this.shippingDate = shippingDate;
    }
    //endregion

    @NonNull
    @Override
    public String toString() {
        return ((Integer) id).toString() + ": " + shippingDate.toString();
    }

}
