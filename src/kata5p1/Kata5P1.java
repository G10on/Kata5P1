package kata5p1;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import static kata5p1.MailListReader.read;

public class Kata5P1 {

    private static String filename = "email.txt";

    public static void main(String[] args) {
        Connection connection = connect("KATA5.db");
        String sql = "INSERT INTO EMAIL(dir) VALUES(?)";
        List<String> readMails = read(filename);
        for (String email : readMails) {
            try {
                PreparedStatement pstmt = connection.prepareStatement(sql);
                pstmt.setString(1, email);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static Connection connect(String dbName) {
        String url = "jdbc:sqlite:" + dbName;
        Connection con = null;
        try {
            con = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return con;
    }
}
