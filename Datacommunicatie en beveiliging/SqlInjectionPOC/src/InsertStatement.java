import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * Created by xaviergeerinck on 29/11/13.
 */
public class InsertStatement extends HttpServlet {
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_CONNECTION = "jdbc:mysql://127.0.0.1:3306/school";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String query = "SELECT * FROM users WHERE name = '" + name + "'";

        Connection dbConnection = null;
        Statement statement = null;

        try {
            dbConnection = getDBConnection();

            // execute select SQL statement
            statement = dbConnection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                String rsName = rs.getString("name");
                out.println("name : " + rsName + "<br />");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }

                if (dbConnection != null) {
                    dbConnection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        out.close();
    }

    private static Connection getDBConnection() {
        Connection dbConnection = null;

        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER,DB_PASSWORD);
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return dbConnection;
    }
}
