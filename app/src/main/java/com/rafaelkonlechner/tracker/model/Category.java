package com.rafaelkonlechner.tracker.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rafael on 06.01.2015.
 */
public class Category implements Parcelable {

    private String name;
    private String unit;
    private List<Element> elements;

    public Category() {
        elements = new ArrayList<Element>();
    }

    public Category(String name, String unit) {
        this();
        this.name = name;
        this.unit = unit;
    }

    public Category(Parcel in) {
        this();
        name = in.readString();
        unit = in.readString();
        in.readTypedList(elements, Element.CREATOR);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public List<Element> getElements() {
        return elements;
    }

    public void addElement(Element e) {
        elements.add(e);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(unit);
        dest.writeTypedList(elements);
    }

    public static final Parcelable.Creator<Category> CREATOR
            = new Parcelable.Creator<Category>() {
        public Category createFromParcel(Parcel in) {
            return new Category(in);
        }

        public Category[] newArray(int size) {
            return new Category[size];
        }
    };

    public String toString() {
        return name;
    }
}
