import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/first")
public class first extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get form data
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String number = request.getParameter("number");
        String subject = request.getParameter("subject");
        String date = request.getParameter("date");
        String time = request.getParameter("time");
        String message = request.getParameter("message");

        // Database connection details
         try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new ServletException("MySQL JDBC driver not found.", e);
        }

        // SQL query to insert form data
        String insertSQL = "INSERT INTO data (name, email, number, subject, date, time, message) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/my", "root", "123456");
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
            // Set values from the form
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, number);
            preparedStatement.setString(4, subject);
            preparedStatement.setString(5, date);
            preparedStatement.setString(6, time);
            preparedStatement.setString(7, message);

            // Execute the insertion
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println(rowsAffected + " row(s) affected.");

            // Redirect to a success page
             response.sendRedirect("success");  
        } catch (SQLException e) {
            e.printStackTrace();
            // Redirect to an error page
            response.sendRedirect("error.html");
        }
    }
}
