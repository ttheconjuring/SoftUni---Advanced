package IteratorsAndComparators.Library;

import java.util.Iterator;

public class Library implements Iterable<Book> {

    private Book[] books;

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    public Library(Book... books) {
        setBooks(books);
    }

    @Override
    public Iterator<Book> iterator() {
        return new LibIterator();
    }

    private final class LibIterator implements Iterator<Book> {
        private int index = 0;

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        @Override
        public boolean hasNext() {
            return getIndex() < getBooks().length;
        }

        @Override
        public Book next() {
            Book next = getBooks()[getIndex()];
            setIndex(getIndex() + 1);
            return next;
        }
    }

}
