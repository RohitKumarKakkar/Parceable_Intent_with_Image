package com.learning.parceableexample;

import android.os.Parcel;
import android.os.Parcelable;

public class Model implements Parcelable {

    private int iImages;
    private String line1;
    private String line2;

    public Model(int iImages, String line1, String line2) {
        this.iImages = iImages;
        this.line1 = line1;
        this.line2 = line2;
    }

    protected Model(Parcel in) {
        iImages = in.readInt();
        line1 = in.readString();
        line2 = in.readString();
    }

    public int getiImages() {
        return iImages;
    }

    public String getLine1() {
        return line1;
    }

    public String getLine2() {
        return line2;
    }
    

    public static final Creator<Model> CREATOR = new Creator<Model>() {
        @Override
        public Model createFromParcel(Parcel in) {
            return new Model(in);
        }

        @Override
        public Model[] newArray(int size) {
            return new Model[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(iImages);
        parcel.writeString(line1);
        parcel.writeString(line2);
    }
}
