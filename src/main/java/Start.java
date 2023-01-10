import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Start {

    public static void main(String[] args) {

        Connection c = null;

        try{
            String url = "jdbc:mysql://localhost:3306/newdb";
            String user = "developer";
            String password = "passwordhere";

            c = DriverManager.getConnection(url, user, password);

            Statement s = c.createStatement();

            String sql = "CREATE TABLE student " +
                    "(student_id INTEGER(10) NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                    " last_name VARCHAR(30), " +
                    " first_name VARCHAR(30))";

            s.executeUpdate(sql);

            s.executeUpdate("INSERT INTO newdb.student (last_name, first_name) VALUES('Marrone', 'Bruno');");
            s.executeUpdate("INSERT INTO newdb.student (last_name, first_name) VALUES('Rossi', 'Damiano');");
            s.executeUpdate("INSERT INTO newdb.student (last_name, first_name) VALUES('Bianchi', 'Giuseppe');");
            s.executeUpdate("INSERT INTO newdb.student (last_name, first_name) VALUES('Verdi', ' Gabriella');");


        }catch(SQLException e) {
            System.out.println(e.getMessage());

        } finally {
            try{
                if(c != null)
                    c.close();
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
}
