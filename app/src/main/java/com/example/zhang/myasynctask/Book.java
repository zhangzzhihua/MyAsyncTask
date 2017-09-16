package com.example.zhang.myasynctask;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2017/8/2.
 */

public class Book implements Parcelable {
    int id ;
    String name;
    Book book = new Book(0,"zoer");
    Book(int id, String name){
        this.id = id;
        this.name = name;
    }
    protected Book(Parcel in) {
        id = in.readInt();
        name = in.readString();
        book = in.readParcelable(Thread.currentThread().getContextClassLoader());
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeParcelable(book,0);
    }
}
