package com.cloudskol.restskol.data;

import com.cloudskol.restskol.model.Book;

import java.util.*;

/**
 * @author tham (zarub2k@gmail.com)
 * Dummay data store class for providing book related information
 */
public class BookDataStore {
    private static final BookDataStore bookDataStore = new BookDataStore();
    private List<Book> availableBooks = new ArrayList<>();

    public static final synchronized BookDataStore getInstance() {
        return bookDataStore;
    }

    public List<Book> getBooks() {
        if (availableBooks.isEmpty()) {
            initialize();
        }

        return availableBooks;
    }

    public Book getBook(String id) {
        if (availableBooks.isEmpty()) {
            initialize();
        }

        for (Book book : availableBooks) {
            if (book.getId().equals(id)) {
                return book;
            }
        }

        return null;
    }

    public void initialize() {
        availableBooks.add(addBook("1", "The Lean Startup", "Eric Ries",
                "0670921602"));
        availableBooks.add(addBook("2", "Zero to one", "Peter Thiel",
                "0753555190"));
        availableBooks.add(addBook("3", "The 100$ Start-up", "Chris Guillebeau",
                "023076651X"));
    }

    public Book addBook(String id, String title,
                           String author, String isbn) {
        final Book book = new Book();
        book.setId(id);
        book.setTitle(title);
        book.setAuthor(author);
        book.setIsbn(isbn);

        return book;
    }
}
