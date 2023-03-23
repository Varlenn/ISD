package main.service;

import main.dto.Avtor;
import main.dto.AvtorController;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        DBConnection dbConn = new DBConnection();
        Avtor avtor = new Avtor("Иван", "Иванов", 1879, 'м');

        AvtorController avtorController = new AvtorController(dbConn);
//        avtorController.insertAvtor(avtor);

        System.out.println("Найдено строк: " + avtorController.selectAvtors().size());
    }
}
