package kata5p1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectApp {

    private Connection connect() {
        String url = "jdbc:sqlite:KATA5.db";
        Connection con = null;
        try {
            con = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return con;
    }

    public void selectAll() {
        String sql = "SELECT * FROM PEOPLE";
        try {
	    Connection con = this.connect();
            Statement sm = con.createStatement();
            ResultSet rs = sm.executeQuery(sql);
            
            while (rs.next()) {
                System.out.println(rs.getInt("Id") + "\t"
                        + rs.getString("Name") + "\t"
                        + rs.getString("Apellidos") + "\t"
                        + rs.getString("Departamento") + "\t");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}