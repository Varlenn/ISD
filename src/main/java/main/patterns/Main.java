package main.patterns;

import main.service.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {

    static DBConnection dbConn;
    static BookController model;
    static BookView view;
    static List<BookController> books;

    public static void main(String[] args) {
        dbConn = new DBConnection();
        model = new BookController();
        view = new BookView();

        retrieveBookFromDatabase("Тургенев");
        model.updateView();
        System.out.println();

        retrieveBookListFromDatabase("Тургенев");

        System.out.println("\nСмена названия");
        model.setBookName("Новое название");
        model.updateView();

        System.out.println();
        bookInformation("Записки охотника");
    }

    public static void retrieveBookFromDatabase(String avtorName) {

        try {
            final ResultSet set = dbConn.getRSet(
                    "select books.bshifr, books.nazv, books.razdel, avtor.fam, avtor.name, avtor.god_r from books left join avtor on " +
                            "books.kod_avtor = avtor.kod_avtor where avtor.fam = '" + avtorName + "'");
            while (set.next()) {
                final String bookName = set.getString("nazv");
                final int bshifr = set.getInt("bshifr");
                final String genre = set.getString("razdel");

                model.setBookBshifr(bshifr);
                model.setBookName(bookName);
                model.setBookGenre(genre);
            }

            set.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<BookController> retrieveBookListFromDatabase(String avtorName) {
        books = new ArrayList<>();
        System.out.println("Все книги указанного автора:");
        try {
            final ResultSet set = dbConn.getRSet(
                    "select books.bshifr, books.nazv, books.razdel, avtor.fam, avtor.name, avtor.god_r from books left join avtor on " +
                            "books.kod_avtor = avtor.kod_avtor where avtor.fam = '" + avtorName + "'");
            while (set.next()) {
                final String bookName = set.getString("nazv");
                final int bshifr = set.getInt("bshifr");
                final String genre = set.getString("razdel");

                books.add(new BookController(bshifr, bookName, genre));
                System.out.println(bshifr + ", " + bookName + ", " + genre);
            }
            set.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    public static void bookInformation(String name) {
        for (BookController book : books)
        if (Objects.equals(book.returnModelName(), name)) {
            System.out.println("информация о книге:" + book.returnModelBshifr() + ", " + book.returnModelGenre());
            break;
        } else {
            System.out.println(book.returnModelName());
            System.out.println("Книги с таким названием не существует");
            break;
        }
    }
}
