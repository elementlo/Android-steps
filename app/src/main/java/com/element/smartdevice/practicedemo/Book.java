package com.element.smartdevice.practicedemo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Arthur on 2016/12/22.
 */

public class Book implements Parcelable {
    public static final Parcelable.Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel parcel) {
            return new Book(parcel);
        }

        @Override
        public Book[] newArray(int i) {
            return new Book[i];
        }

    };
    public int bookId, bookNum;
    public String bookName;

    public Book(int bookId,String bookName){
        this.bookNum=bookId;
        this.bookName=bookName;
        this.bookId=bookId;
    }

    private Book(Parcel in) {
        bookId = in.readInt();
        bookNum=in.readInt();
        bookName=in.readString();

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(bookId);
        parcel.writeInt(bookNum);
        parcel.writeString(bookName);
    }
}
