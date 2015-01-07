package com.rafaelkonlechner.tracker.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by Rafael on 06.01.2015.
 */
public class Element implements Parcelable {

    private double value;
    private Date date;

    public Element(double value, Date date) {
        this.value = value;
        this.date = date;
    }

    public Element(Parcel in) {
        value = in.readDouble();
        date = (Date) in.readSerializable();
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(value);
        dest.writeSerializable(date);
    }

    public static final Parcelable.Creator<Element> CREATOR
            = new Parcelable.Creator<Element>() {
        public Element createFromParcel(Parcel in) {
            return new Element(in);
        }

        public Element[] newArray(int size) {
            return new Element[size];
        }
    };
}
