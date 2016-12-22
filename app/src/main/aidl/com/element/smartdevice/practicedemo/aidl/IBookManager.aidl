// IBookManager.aidl
package com.element.smartdevice.practicedemo.aidl;
import com.element.smartdevice.practicedemo.beans.Book;

// Declare any non-default types here with import statements

interface IBookManager {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    List<Book> getBookList();
    void addBook(in Book book);
}
