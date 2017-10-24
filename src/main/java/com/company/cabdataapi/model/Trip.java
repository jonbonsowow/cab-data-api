package com.company.cabdataapi.model;

import java.util.Date;

import javax.persistence.*;

/**
 *
 * Entity class for the CAB_TRIP_DATA table
 *
 * Created by Jon Bonso on 22/10/17.
 */
@Entity
@Table(name = "cab_trip_data")
public class Trip {

    @Id
    private String medallion;

    private String hack_license;
    private String vendor_id;
    private int rate_code;
    private String store_and_fwd_flag;
    private Date pickup_datetime;
    private Date dropoff_datetime;
    private int passenger_count;
    private int trip_time_in_secs;
    private double trip_distance;
    private double pickup_longitude;
    private double pickup_latitude;
    private double dropoff_longitude;
    private double dropoff_latitude;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Trip trip = (Trip) o;

        if (rate_code != trip.rate_code) return false;
        if (passenger_count != trip.passenger_count) return false;
        if (trip_time_in_secs != trip.trip_time_in_secs) return false;
        if (Double.compare(trip.trip_distance, trip_distance) != 0) return false;
        if (Double.compare(trip.pickup_longitude, pickup_longitude) != 0) return false;
        if (Double.compare(trip.pickup_latitude, pickup_latitude) != 0) return false;
        if (Double.compare(trip.dropoff_longitude, dropoff_longitude) != 0) return false;
        if (Double.compare(trip.dropoff_latitude, dropoff_latitude) != 0) return false;
        if (medallion != null ? !medallion.equals(trip.medallion) : trip.medallion != null) return false;
        if (hack_license != null ? !hack_license.equals(trip.hack_license) : trip.hack_license != null) return false;
        if (vendor_id != null ? !vendor_id.equals(trip.vendor_id) : trip.vendor_id != null) return false;
        if (store_and_fwd_flag != null ? !store_and_fwd_flag.equals(trip.store_and_fwd_flag) : trip.store_and_fwd_flag != null)
            return false;
        if (pickup_datetime != null ? !pickup_datetime.equals(trip.pickup_datetime) : trip.pickup_datetime != null)
            return false;
        return dropoff_datetime != null ? dropoff_datetime.equals(trip.dropoff_datetime) : trip.dropoff_datetime == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = medallion != null ? medallion.hashCode() : 0;
        result = 31 * result + (hack_license != null ? hack_license.hashCode() : 0);
        result = 31 * result + (vendor_id != null ? vendor_id.hashCode() : 0);
        result = 31 * result + rate_code;
        result = 31 * result + (store_and_fwd_flag != null ? store_and_fwd_flag.hashCode() : 0);
        result = 31 * result + (pickup_datetime != null ? pickup_datetime.hashCode() : 0);
        result = 31 * result + (dropoff_datetime != null ? dropoff_datetime.hashCode() : 0);
        result = 31 * result + passenger_count;
        result = 31 * result + trip_time_in_secs;
        temp = Double.doubleToLongBits(trip_distance);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(pickup_longitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(pickup_latitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(dropoff_longitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(dropoff_latitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public Trip(String medallionId, Date pickupDate){
        this.medallion = medallionId;
        this.pickup_datetime = pickupDate;
    }


    public double getDropoff_latitude() {
        return dropoff_latitude;
    }

    public void setDropoff_latitude(double dropoff_latitude) {
        this.dropoff_latitude = dropoff_latitude;
    }

    public String getMedallion() {
        return medallion;
    }

    public void setMedallion(String medallion) {
        this.medallion = medallion;
    }

    public String getHack_license() {
        return hack_license;
    }

    public void setHack_license(String hack_license) {
        this.hack_license = hack_license;
    }

    public String getVendor_id() {
        return vendor_id;
    }

    public void setVendor_id(String vendor_id) {
        this.vendor_id = vendor_id;
    }

    public int getRate_code() {
        return rate_code;
    }

    public void setRate_code(int rate_code) {
        this.rate_code = rate_code;
    }

    public String getStore_and_fwd_flag() {
        return store_and_fwd_flag;
    }

    public void setStore_and_fwd_flag(String store_and_fwd_flag) {
        this.store_and_fwd_flag = store_and_fwd_flag;
    }

    public Date getPickup_datetime() {
        return pickup_datetime;
    }

    public void setPickup_datetime(Date pickup_datetime) {
        this.pickup_datetime = pickup_datetime;
    }

    public Date getDropoff_datetime() {
        return dropoff_datetime;
    }

    public void setDropoff_datetime(Date dropoff_datetime) {
        this.dropoff_datetime = dropoff_datetime;
    }

    public int getPassenger_count() {
        return passenger_count;
    }

    public void setPassenger_count(int passenger_count) {
        this.passenger_count = passenger_count;
    }

    public int getTrip_time_in_secs() {
        return trip_time_in_secs;
    }

    public void setTrip_time_in_secs(int trip_time_in_secs) {
        this.trip_time_in_secs = trip_time_in_secs;
    }

    public double getTrip_distance() {
        return trip_distance;
    }

    public void setTrip_distance(double trip_distance) {
        this.trip_distance = trip_distance;
    }

    public double getPickup_longitude() {
        return pickup_longitude;
    }

    public void setPickup_longitude(double pickup_longitude) {
        this.pickup_longitude = pickup_longitude;
    }

    public double getPickup_latitude() {
        return pickup_latitude;
    }

    public void setPickup_latitude(double pickup_latitude) {
        this.pickup_latitude = pickup_latitude;
    }

    public double getDropoff_longitude() {
        return dropoff_longitude;
    }

    public void setDropoff_longitude(double dropoff_longitude) {
        this.dropoff_longitude = dropoff_longitude;
    }


}
