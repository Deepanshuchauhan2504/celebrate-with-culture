import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class success extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String pageTitle = "Success";
        String successMessage = "Data Stored Successfully!";
        String bodyMessage = "Your data has been successfully stored in the database.";
        String backButton = "<a href=\"index.html\">Go back to form</a>";

        // Construct the HTML content
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>" + pageTitle + "</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>" + successMessage + "</h1>");
        out.println("<p>" + bodyMessage + "</p>");
        out.println("<p>" + backButton + "</p>");
        out.println("</body>");
        out.println("</html>");
    }
}
