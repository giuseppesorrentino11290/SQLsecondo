import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Start {

    public static void main(String[] args) {

        Connection con = null;

        try{
            String url = "jdbc:mysql://localhost:3306/newdb";
            String user = "developer";
            String password = "passwordhere";

            con = DriverManager.getConnection(url, user, password);

            Statement s = con.createStatement();

            String sql = "CREATE TABLE student " +
                    "(student_id INTEGER(10) NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                    " last_name VARCHAR(30), " +
                    " first_name VARCHAR(30))";

            s.executeUpdate(sql);

            s.execute("INSERT INTO newdb.student (last_name, first_name) VALUES('Sorrentino', 'Giuseppe');");
            s.execute("INSERT INTO newdb.student (last_name, first_name) VALUES('Auditore', 'Ezio');");
            s.execute("INSERT INTO newdb.student (last_name, first_name) VALUES('Miles', 'Desmond');");
            s.execute("INSERT INTO newdb.student (last_name, first_name) VALUES('Eivor', ' Morso di Lupo');");


        }catch(SQLException e) {
            System.out.println(e.getMessage());

        } finally {
            try{
                if(con != null)
                    con.close();
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
}
