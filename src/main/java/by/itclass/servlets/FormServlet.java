package by.itclass.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;

@WebServlet(value = "/form")
public class FormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        var name = req.getParameter("userName");
        var age = req.getParameter("userAge");
        var gender = req.getParameter("gender");
        var country = req.getParameter("country");
        var courses = req.getParameterValues("courses");
        var writer = resp.getWriter();
        writer.write("<p> Name: " + name + "</p>");
        writer.write("<p> Age: " + age + "</p>");
        writer.write("<p> Gender: " + gender + "</p>");
        writer.write("<p> Country: " + country + "</p>");
        writer.write("<p>Courses:</p>");
        writer.write("<ol>");
        Arrays.stream(courses)
                .forEach(it -> writer.write("<li>" + it + "</li>"));
        writer.write("</ol>");
    }
}
