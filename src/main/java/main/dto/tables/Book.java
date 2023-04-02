package main.dto.tables;

public class Book {
    Integer bshifr;
    String avtorName;
    String bookName;

    public Book(Integer bshifr, String avtorName, Avtor bookName) {
        this.bshifr = bshifr;
        this.avtorName = avtorName;
        this.bookName = String.valueOf(bookName);
    }

    public String getAvtorName() {
        return avtorName;
    }

    public void setAvtorName(String avtorName) {
        this.avtorName = avtorName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        bookName = bookName;
    }

    public Integer getBshifr() {
        return bshifr;
    }

    public void setBshifr(Integer bshifr) {
        this.bshifr = bshifr;
    }
}
