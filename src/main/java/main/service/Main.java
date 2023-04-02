package main.service;
import main.dto.controllers.ReaderController;
import main.dto.tables.Avtor;
import main.dto.controllers.AvtorController;
import main.dto.tables.Book;
import main.dto.tables.Reader;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException, UnsupportedEncodingException {
//        // создание подключения к БД
        DBConnection dbConn = new DBConnection();
//        // создание нового автора
//        Avtor avtor = new Avtor("Иван", "Иванов", 1879, 'м');
//
//        // добавление подключения к классу, содержащему управляющие функции
//        AvtorController avtorController = new AvtorController(dbConn);
//
//        // вызов функции добавления нового автора
//        avtorController.insertAvtor(avtor);
//        // вызов функции обновления автора по id
//        avtorController.updateAvtor(33, new Avtor("Романова", "Елизавета", 1900, 'ж'));
//        // вызов функции вывода всей информации об авторе по id
//        avtorController.absoluteSelect(33);
//        // вызов функции удаления автора по id с предподготовленной переменной
//        avtorController.deleteAvtor("35 or kod_avtor = 36");
//        // вызов функции удаления автора по id с SQL инъекцией
//        avtorController.deleteAvtor("35 or kod_avtor = 36");
//
//
//        // вызов функции добавления новых авторов путем чтения данных из файла
//        for (final Avtor avtorFromFile : AvtorController.insertAvtorsFromFile("src/main/resources/import.txt")) {
//            avtorController.insertAvtor(avtorFromFile);
//        }
//
//        // вызов функции определения количества записей в таблице
//        String res = "Найдено строк: " + avtorController.selectAvtors().size();
//        System.out.println(new String(res.getBytes("UTF-8"), "windows-1251"));

//        List<Book> books = database.loadBooks("first", "second", "last");


        ReaderController controller = new ReaderController(dbConn);
        Reader reader = controller.getReader(3356);
        List<Book> books = controller.getBooks("Лгун", "Теория цвета", "Война и мир");

        String res = controller.getReader(3356).getFam();
        System.out.println(new String(res.getBytes("UTF-8"), "windows-1251"));
        System.out.println("\n");

        controller.takeBook(3);
        controller.takeBook("Лгун", "Теория цвета", "Война и мир");
        controller.takeBook(reader, books);
//        System.out.println("\n");

        controller.returnBook(3);
        controller.returnBook("Лгун", "Теория цвета", "Война и мир");
//        controller.returnBook(reader, books);

        System.out.println();
    }
}
