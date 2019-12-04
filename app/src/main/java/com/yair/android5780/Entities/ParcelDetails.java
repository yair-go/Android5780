package com.yair.android5780.Entities;

import android.location.Location;

/**
 * Created by Yair on 04/12/2019.
 */
public class ParcelDetails {
    private int id;
    private Enums.ParcelStatus parcelStatus;
    private Enums.ParcelType parcelType;
    private Enums.ParcelWeight parcelWeight;
    private Location location;
    private Recipient recipient;

    public ParcelDetails(int id, Enums.ParcelStatus parcelStatus, Enums.ParcelType parcelType, Enums.ParcelWeight parcelWeight, Location location, Recipient recipient) {
        this.id = id;
        this.parcelStatus = parcelStatus;
        this.parcelType = parcelType;
        this.parcelWeight = parcelWeight;
        this.location = location;
        this.recipient = recipient;
    }


}
