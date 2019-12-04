package com.yair.android5780.Entities;

/**
 * Created by Yair on 04/12/2019.
 */
public class Enums {

    public enum ParcelStatus{
        sent,
        inWay,
        received,
    }
    public enum ParcelType{
        envelope,
        small,
        large,
    }
    public enum ParcelWeight{
        under500gr,
        under1kg,
        under5Kg,
        under20Kg,
        Huge,
    }
}

