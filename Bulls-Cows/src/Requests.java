
import java.sql.*;
import java.util.Scanner;

public class Requests {

    static void selectBy(Connection conn, int choose) { // choose = 1 - для сортировки по времени, 2 - по шагам
        try {
            ResultSet resultSet = null;
            Statement statement = conn.createStatement();
            switch (choose) {
                case 1:
                    System.out.println("Сортировка по времени");
                    resultSet = statement.executeQuery("SELECT * FROM Statistic ORDER BY Time");
                    break;
                case 2:
                    System.out.println("Сортировка по шагам");
                    resultSet = statement.executeQuery("SELECT * FROM Statistic ORDER BY Steps");
                    break;
            }
            System.out.println("Имя: \t\t Время(c): \t Количество шагов:");
            while (resultSet.next()) {
                String name = resultSet.getString("Name");
                int time = resultSet.getInt("Time");
                int steps = resultSet.getInt("Steps");
                System.out.printf("%s \t\t %d \t\t %d\n", name, time, steps);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    static void selectByName(Connection conn) {
        try {
            System.out.println("Введите имя");
            Scanner in = new Scanner(System.in);
            String userName = in.nextLine();
            while (userName.equals("")) {
                System.out.println("Имя не может быть пустым. Введите имя заново: ");
                in = new Scanner(System.in);
                userName = in.nextLine();
            }
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Statistic WHERE [Name] = '" + userName + "'");
            System.out.println("Имя: \t Время(c): \t Количество шагов:");
            while (resultSet.next()) {
                String name = resultSet.getString("Name");
                int time = resultSet.getInt("Time");
                int steps = resultSet.getInt("Steps");
                System.out.printf("%s \t %d \t\t %d\n", name, time, steps);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    static void saveIntoBd(Connection conn, String name, int time, int steps) {
        try {
            Statement statement = conn.createStatement();
            int rows = statement.executeUpdate("INSERT Statistic VALUES ('" + name + "','" + time + "','" + steps + "')");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }


}
