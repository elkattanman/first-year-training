package supermarket;

import java.sql.*;

/**
 * @author Mustafa Khaled
 */
public class mysql {

    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String user = "root";
        String pass = "";

        try {
            //1 -Get connection to database
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Supermarket", user, pass);
            //2- create a statement
            stmt = conn.createStatement();
            //3-execute sql query
            rs = stmt.executeQuery("show tables");
            while (rs.next()) {
                System.out.println(rs.getString("id") + "  " + rs.getString("pName"));
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            if(rs != null)
                rs.close();
            if(stmt != null)
                stmt.close();
            if(conn != null)
                conn.close();
            
        }
    }

}
