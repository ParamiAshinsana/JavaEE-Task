package com.example.demotask.api;

import lombok.var;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet(name = "user", urlPatterns = "/*",
        initParams = {
                @WebInitParam(name = "db-user", value = "root"),
                @WebInitParam(name = "db-pw", value = "1234"),
                @WebInitParam(name = "db-url", value = "jdbc:mysql://localhost:3306/usertask?createDatabaseIfNotExist=true"),
                @WebInitParam(name = "db-class", value = "com.mysql.cj.jdbc.Driver"),
        },
        loadOnStartup = 5)
public class User extends HttpServlet {

    Connection connection;
    private static final String SAVE_DATA = "INSERT INTO Users(ID,NAME,CITY) VALUES (?,?,?)";

    @Override
    public void init() throws ServletException {
        System.out.println("Hello Init");
        try {
            var user = getServletConfig().getInitParameter("db-user");
            var password = getServletConfig().getInitParameter("db-pw");
            var url = getServletConfig().getInitParameter("db-url");
            var dbClass = getServletConfig().getInitParameter("db-class");

            Class.forName(dbClass);
            this.connection = DriverManager.getConnection(url, user, password);
            System.out.println("\n");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Hello doGet"+"\n");


        System.out.println("Context Path :"+req.getContextPath());
        System.out.println("Path Info  : "+req.getPathInfo());
        System.out.println("Path Translated : "+req.getPathTranslated());
        System.out.println("Query String : "+req.getQueryString());

        System.out.println("\n");

        System.out.println("Request URI : "+req.getRequestURI());
        System.out.println("Custom Headers : "+req.getRequestURL()+"?"+req.getQueryString());
        System.out.println("\n");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("\n\n");
        System.out.println("Hello User-doPost");

        var id = req.getParameter("id");
        var name = req.getParameter("name");
        var city = req.getParameter("city");
        var writer = resp.getWriter();

        resp.setContentType("text/html");

        try {
            var ps = connection.prepareStatement(SAVE_DATA);

            ps.setString(1, id);
            ps.setString(2, name);
            ps.setString(3, city);

            System.out.println("ID : "+id);
            System.out.println("NAME : "+name);
            System.out.println("CITY : "+city);

            if (ps.executeUpdate() != 0) {
                writer.println("User Data Saved!");
                System.out.println("Saved");
            } else {
                writer.println("Failed to save user data!");
                System.out.println("Not Saved");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
