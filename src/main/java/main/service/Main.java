package main.service;
import main.dto.Avtor;
import main.dto.AvtorController;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException, UnsupportedEncodingException {
        // создание подключения к БД
        DBConnection dbConn = new DBConnection();
        // создание нового автора
        Avtor avtor = new Avtor("Иван", "Иванов", 1879, 'м');

        // добавление подключения к классу, содержащему управляющие функции
        AvtorController avtorController = new AvtorController(dbConn);

        // вызов функции добавления нового автора
        avtorController.insertAvtor(avtor);
        // вызов функции обновления автора по id
        avtorController.updateAvtor(33, new Avtor("Романова", "Елизавета", 1900, 'ж'));
        // вызов функции вывода всей информации об авторе по id
        avtorController.absoluteSelect(33);
        // вызов функции удаления автора по id с предподготовленной переменной
        avtorController.deleteAvtor("35 or kod_avtor = 36");
        // вызов функции удаления автора по id с SQL инъекцией
        avtorController.deleteAvtor("35 or kod_avtor = 36");


        // вызов функции добавления новых авторов путем чтения данных из файла
        for (final Avtor avtorFromFile : AvtorController.insertAvtorsFromFile("src/main/resources/import.txt")) {
            avtorController.insertAvtor(avtorFromFile);
        }

        // вызов функции определения количества записей в таблице
        String res = "Найдено строк: " + avtorController.selectAvtors().size();
        System.out.println(new String(res.getBytes("UTF-8"), "windows-1251"));


//        String MARKER = "__MARKER_I__";
//        try {
//            res = "Иванов";
//            res = new String(res.getBytes("UTF-8"), "windows-1251");
//            String CYRILLIC_I = new String("И".getBytes("UTF-8"), "windows-1251");
//            res = res.replace(CYRILLIC_I, MARKER);
//            System.out.println(CYRILLIC_I);
//
//            String s = new String("И".getBytes("windows-1251"), "UTF-8");
//            System.out.println(s);
//            res = res.replace(MARKER, s);
//            System.out.println(res);
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
    }
}
