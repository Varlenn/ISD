package main.dto.controllers;

import main.dto.tables.Avtor;
import main.dto.tables.Book;
import main.dto.tables.Reader;
import main.service.DBConnection;

import java.io.UnsupportedEncodingException;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReaderController {

    private final DBConnection connection;
    public ReaderController(DBConnection connection) {
        this.connection = connection;
    }

    public Reader getReader(int id) {
        try {
            final ResultSet set = connection.getRSet(
                    "select * from users where kod_user =" + id);
            while (set.next()) {
                final String fam = set.getString("fam");
                final String name = set.getString("name");
                final Integer god_r = set.getInt("god_r");
                final Integer gruppa = set.getInt("gruppa");
                Array a= set.getArray("phone");
                String[] myArray = (String[]) a.getArray();
                return new Reader(id, fam, name, god_r, gruppa, myArray);
            }
            set.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    public List<Book> getBooks(String... names) {
        final List<Book> books = new ArrayList<>();
        try {
            final ResultSet set = connection.getRSet(
                    "select books.bshifr, books.nazv, avtor.fam, avtor.name, avtor.god_r " +
                            "from books left join avtor on books.kod_avtor = avtor.kod_avtor where books.nazv in ('" + String.join("','", names) + "')");
            while (set.next()) {
                final String bookName = set.getString("nazv");
                final String fam = set.getString("fam");
                final String name = set.getString("name");
                final int god_r = set.getInt("god_r");
                final int bshifr = set.getInt("bshifr");

                books.add(new Book(bshifr, bookName, new Avtor(fam, name, god_r)));
            }

            set.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return books;
    }


    public void takeBook(Integer num) throws UnsupportedEncodingException {
        String res = "Ерофеев взял " + num + " книги";
        System.out.println(new String(res.getBytes("UTF-8"), "windows-1251"));
    }

    public void takeBook(String... bookName) throws UnsupportedEncodingException {
        String res = "Ерофеев взял книги: " + String.join(", ", bookName);
        System.out.println(new String(res.getBytes("UTF-8"), "windows-1251"));
    }

    public void takeBook(Reader reader, List<Book> books) throws SQLException {
        for (final var book : books) {
            connection.executeQuery("insert into bilet (bshifr, kod_user) values (" + book.getBshifr() + ", " + reader.getKod_user() + ")");
        }
    }


    public void returnBook(Integer num) throws UnsupportedEncodingException {
        String res = "Ерофеев вернул " + num + " книги";
        System.out.println(new String(res.getBytes("UTF-8"), "windows-1251"));
    }

    public void returnBook(String... bookName) throws UnsupportedEncodingException {
        String res = "Ерофеев вернул книги: " + String.join(", ", bookName);
        System.out.println(new String(res.getBytes("UTF-8"), "windows-1251"));
    }

        public void returnBook(Reader reader, List<Book> books) throws SQLException {
        for (final var book : books) {
            connection.executeQuery("delete from bilet where bshifr = " + book.getBshifr() + " and kod_user = " + reader.getKod_user());
        }
    }
}
