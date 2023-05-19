package main.lambda;

import main.service.DBConnection;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AvtorControllerL {

    private final DBConnection connection;

    public AvtorControllerL(DBConnection connection) {
        this.connection = connection;
    }

    // функция отправки запроса на добавление записи
    public void insertAvtor(AvtorL avtor) throws SQLException {
        connection.executeQuery("insert into avtor (name, fam, god_r, pol) values ('" + avtor.name + "', '" + avtor.fam + "', " +
                avtor.god_r + ", '" + avtor.pol + "')");

        System.out.println("affected: " + connection.getUpdateCount());
    }

    // функция отправки запроса на обновление записи
    public void updateAvtor(int id, AvtorL avtor) throws SQLException {
        connection.executeQuery("update avtor set fam = '" + avtor.fam + "', name = '" + avtor.name + "', god_r = " + avtor.god_r + ", pol = '"
                + avtor.pol + "' where kod_avtor = " + id + "");

        System.out.println("affected: " + connection.getUpdateCount());
    }

    // функция отправки запроса на удаление записи
    public void deleteAvtorSQL(String id) {
        try {
            connection.executeQuery("delete from avtor where kod_avtor=" + id + "");

            System.out.println("affected: " + connection.getUpdateCount());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAvtor(String id) {
        try {
            final PreparedStatement statement = connection.getConnection().prepareStatement("delete from avtor where kod_avtor=?");
            statement.setInt(1, Integer.parseInt(id));
            statement.execute();

            System.out.println("affected: " + statement.getUpdateCount());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // функция возврата списка всех записей таблицы
    public List<AvtorL> selectAvtors() {
        final List<AvtorL> list = new ArrayList<>();

        try {
            final ResultSet set = connection.getRSet("select * from avtor");
            while (set.next()) {
                final String fam = set.getString("fam");
                final String name = set.getString("name");
                final int god_r = set.getInt("god_r");
                final Character pol = set.getString("pol").charAt(0);

                list.add(new AvtorL(fam, name, god_r, pol));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // функция вывода всей информации о авторе по id
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

        } catch (SQLException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    // функция возвращающая данные об авторе путем чтения файла
    public static List<AvtorL> insertAvtorsFromFile(String filePath) {
        final List<AvtorL> list = new ArrayList<>();

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
                list.add(new AvtorL(name, fam, god_r, pol));
            }
        } catch (NumberFormatException | IOException e) {
            e.printStackTrace();
        }

        return list;
    }

    public void searchAvtors(int age) {
        final List<AvtorL> list = new ArrayList<>();

        try (final ResultSet set = connection.getRSet("select * from avtor")) {
            while (set.next()) {
                final String fam = set.getString("fam");
                final String name = set.getString("name");
                final int god_r = set.getInt("god_r");
                if (god_r > age) {
                    continue;
                }

                list.add(new AvtorL(fam, name, god_r));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String res = "Авторов, младше " + age + " года " + list.size();
        System.out.println(res);
    }

    public void searchAvtorsLambda(int age) {
        final List<AvtorL> list = new ArrayList<>();

        try (final ResultSet set = connection.getRSet("select * from avtor")) {
            while (set.next()) {
                final String fam = set.getString("fam");
                final String name = set.getString("name");
                final int god_r = set.getInt("god_r");

                list.add(new AvtorL(fam, name, god_r));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        final var newList = list.stream().filter(avtor -> {
            String res = avtor.fam + " " + avtor.name + " " + avtor.god_r;
            System.out.println(res);
            return avtor.god_r < age;
        }).toList();

        String res = "\nАвторов младше " + age + " года " + newList.size();
        System.out.println(res);

        res = String.join(",", newList.stream().map(avtorL -> avtorL.fam).toList());
        System.out.println("\n" + res);

        res = String.join(",", Functions.upCase(newList.stream().map(avtorL -> avtorL.fam).collect(Collectors.toList())));
        System.out.println("\n" + res);

        System.out.println("\nСамое длинное имя " + list.stream().reduce((avtor, avtor2) -> {
            if (avtor.name.length() > avtor2.name.length()) {
                return avtor;
            } else {
                return avtor2;
            }
        }).get().name);
    }

    public int searchAvtorsYearSum() {
        final List<AvtorL> list = new ArrayList<>();

        try (final ResultSet set = connection.getRSet("select * from avtor")) {
            while (set.next()) {
                final String secondName = set.getString("fam");
                final String name = set.getString("name");
                final int bornYear = set.getInt("god_r");

                list.add(new AvtorL(secondName, name, bornYear));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list.parallelStream().mapToInt(avtorL -> avtorL.god_r).sum();
    }
}
