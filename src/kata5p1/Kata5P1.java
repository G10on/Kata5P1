package kata5p1;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Kata5P1 {

    public static void main(String[] args) {
        createTable();
    }
    
    public static void createTable() {
        
        String url = "jdbc:sqlite:KATA5.db";
        String sql = "CREATE TABLE IF NOT EXISTS EMAIL (\n"
                + " id integer PRIMARY KEY AUTOINCREMENT,\n"
                + " dir text NOT NULL);";
        
        try {
            Connection conn = DriverManager.getConnection(url);
            Statement sm = conn.createStatement();
            sm.execute(sql);
            System.out.println("Tabla creada");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
