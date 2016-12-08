package com.mobileappclass.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by talhamahmood on 11/30/16.
 */

public class Book implements Parcelable{

    private  int name;
    private  int author;
    private  int imageResource;
    private boolean isFavorite = false;



    public Book(int name, int author, int imageResource) {
        this.name = name;
        this.author = author;
        this.imageResource = imageResource;
    }

    public Book(int name, int imageResource){
        this.name = name;
        this.imageResource = imageResource;
    }

    public Book(){

    }

    protected Book(Parcel in) {
        name = in.readInt();
        author = in.readInt();
        imageResource = in.readInt();
        isFavorite = in.readByte() != 0;
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    public void setName(int name) {

        this.name = name;
    }

    public void setAuthor(int author) {

        this.author = author;
    }

    public void setImageResource(int imageResource) {

        this.imageResource = imageResource;
    }


    public int getName() {

        return name;
    }

    public int getAuthor() {

        return author;
    }

    public int getImageResource() {

        return imageResource;
    }

    public boolean getIsFavorite() {

        return isFavorite;
    }
    public void setIsFavorite(boolean isFavorite) {

        this.isFavorite = isFavorite;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(name);
        dest.writeInt(author);
        dest.writeInt(imageResource);
        dest.writeByte((byte) (isFavorite ? 1 : 0));
    }
}
