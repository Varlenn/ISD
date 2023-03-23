package main.dto;

import main.service.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AvtorController {
    private final DBConnection connection;

    public AvtorController(DBConnection connection) {
        this.connection = connection;
    }

    public void insertAvtor(Avtor avtor) throws SQLException {

        connection.executeQuery("insert into avtor (name, fam, god_r, pol) values ('" + avtor.getName() + "', '" + avtor.getFam() + "', '" +
                avtor.getGod_r() + "', '" + avtor.getPol() + "')");
        System.out.println("affected " + connection.getUpdateCount());
    }

    public List<Avtor> selectAvtors() {
        final List<Avtor> list = new ArrayList<>();

        try {

            final ResultSet set = connection.getRSet("select * from avtor");
            while (set.next()) {
                final String fam = set.getString("fam");
                final String name = set.getString("name");
                final int god_r = set.getInt("god_r");
                final Character pol = set.getString("pol").charAt(0);

                list.add(new Avtor(fam, name, god_r, pol));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
