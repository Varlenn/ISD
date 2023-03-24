package main.dto;

import main.service.DBConnection;

import java.io.*;
import java.sql.PreparedStatement;
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
        connection.executeQuery("insert into avtor (name, fam, god_r, pol) values ('" + avtor.getName() + "', '" + avtor.getFam() + "', " +
                avtor.getGod_r() + ", '" + avtor.getPol() + "')");
        System.out.println("affected: " + connection.getUpdateCount());
    }

    public void updateAvtor(int id, Avtor avtor) throws SQLException {
        connection.executeQuery("update avtor set fam = '" + avtor.getFam() + "', name = '" + avtor.getName() + "', god_r = " + avtor.getGod_r() + ", pol = '"
                + avtor.getPol() + "' where kod_avtor = " + id + "");
        System.out.println("affected: " + connection.getUpdateCount());
    }

    public void deleteAvtor(String id) {
        try {
            final PreparedStatement statement = connection.getConnection().prepareStatement("delete from avtor where kod_avtor=" + id + "");
            statement.execute();

            System.out.println("affected: " + statement.getUpdateCount());
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

//    public List<Avtor> absolutePosit(int i) throws SQLException {
//        Statement statement = connection.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
//        ResultSet.absolute
//    }

    public void absoluteSelect(int id) {
        try {
            final ResultSet set = connection.getRSet("select * from avtor where kod_avtor=" + id);
            set.next();

            final String name = set.getString("name");
            final String fam = set.getString("fam");
            final int god_r = set.getInt("god_r");
            final Character pol = set.getString("pol").charAt(0);

            String res = name + " " + fam + " " + god_r + " " + pol;
            System.out.println(new String(res.getBytes("UTF-8"), "windows-1251"));

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public static List<Avtor> insertAvtorsFromFile(String filePath) {
        final List<Avtor> list = new ArrayList<>();

        try {
            final BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(filePath), "UTF8"));
            String line = reader.readLine();
            while (line != null) {
                final String[] args = line.split(",");
                final String name = args[0];
                final String fam = args[1];
                final int god_r = Integer.parseInt(args[2]);
                final Character pol = args[3].charAt(0);

                line = reader.readLine();
                list.add(new Avtor(name, fam, god_r, pol));
            }
        } catch (NumberFormatException | IOException e) {
            e.printStackTrace();
        }

        return list;
    }
}
