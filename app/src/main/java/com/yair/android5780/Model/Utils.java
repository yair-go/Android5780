package com.yair.android5780.Model;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

/**
 * Created by Yair on 19/12/2019.
 */
public class Utils {

    public static String getPlace(Context context, Location location) {

        Geocoder geocoder = new Geocoder(context, Locale.getDefault());
        List<Address> addresses = null;
        try {
            addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
            if (addresses.size() > 0) {

                String address = addresses.get(0).getAddressLine(0);
                Double latitude = addresses.get(0).getLatitude();
                Double longitude = addresses.get(0).getLongitude();
//                String cityName = addresses.get(0).getLocality();
//                String stateName = addresses.get(0).getAdminArea();
//                String countryName = addresses.get(0).getCountryName();
//                return stateName + "\n" + cityName + "\n" + countryName;
                return latitude + "\n"  + longitude + "\n" + address;
            }
            return "no place: \n (" + location.getLongitude() + " , " + location.getLatitude() + ")";
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return "IOException ...";
    }
    public static String getPlace(Context context, Double latitude,  Double longitude) {

        Geocoder geocoder = new Geocoder(context, Locale.getDefault());
        List<Address> addresses = null;
        try {
            addresses = geocoder.getFromLocation(latitude, longitude, 1);
            if (addresses.size() > 0) {

                String address = addresses.get(0).getAddressLine(0);
                return address;
            }
            return "no place: \n (" + longitude + " , " + latitude + ")";
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return "IOException ...";
    }
}
