package main.service;

import main.dto.Avtor;
import main.dto.AvtorController;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException, UnsupportedEncodingException {
        DBConnection dbConn = new DBConnection();
//        Avtor avtor = new Avtor("Иван", "Иванов", 1879, 'м');

        AvtorController avtorController = new AvtorController(dbConn);

//        avtorController.insertAvtor(avtor);
//        avtorController.updateAvtor(14, new Avtor("Романова", "Елизавета", 1900, 'ж'));
//        avtorController.deleteAvtor("25");
        avtorController.absoluteSelect(6);

//        for (final Avtor avtor : AvtorController.insertAvtorsFromFile("src/main/resources/import.txt")) {
//            avtorController.insertAvtor(avtor);
//        }

        String res = "Найдено строк: " + avtorController.selectAvtors().size();
        System.out.println(new String(res.getBytes("UTF-8"), "windows-1251"));
    }
}
