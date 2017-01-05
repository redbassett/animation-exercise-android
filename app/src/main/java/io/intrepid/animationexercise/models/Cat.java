package io.intrepid.animationexercise.models;

import android.os.Parcel;
import android.os.Parcelable;

import org.simpleframework.xml.Element;

public class Cat implements Parcelable {

    @Element
    private String url;

    @Element
    private String id;

    @Element(name = "source_url")
    private String source;

    public Cat() {
    }

    public Cat(String id, String url) {
        this.id = id;
        this.url = url;
    }

    protected Cat(Parcel in) {
        this.url = in.readString();
        this.id = in.readString();
        this.source = in.readString();
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.url);
        dest.writeString(this.id);
        dest.writeString(this.source);
    }

    public static final Creator<Cat> CREATOR = new Creator<Cat>() {
        @Override
        public Cat createFromParcel(Parcel source) {
            return new Cat(source);
        }

        @Override
        public Cat[] newArray(int size) {
            return new Cat[size];
        }
    };
}
